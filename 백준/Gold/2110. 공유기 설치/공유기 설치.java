import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = sToi(st.nextToken()); // 집의 개수
        int C = sToi(st.nextToken()); // 공유기의 개수
        
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = sToi(br.readLine());
        }
        
        // 집 좌표를 정렬
        Arrays.sort(houses);
        
        // 이분 탐색으로 최대 거리 찾기
        int left = 1; // 최소 거리
        int right = houses[N-1] - houses[0]; // 최대 거리
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            // mid 거리로 C개의 공유기를 설치할 수 있는지 확인
            if (canInstall(houses, C, mid)) {
                answer = mid;
                left = mid + 1; // 더 큰 거리 시도
            } else {
                right = mid - 1; // 더 작은 거리 시도
            }
        }
        
        System.out.println(answer);
    }
    
    // 주어진 거리로 C개의 공유기를 설치할 수 있는지 확인
    private static boolean canInstall(int[] houses, int C, int distance) {
        int count = 1; // 첫 번째 집에 공유기 설치
        int lastInstalled = houses[0]; // 마지막으로 설치한 공유기 위치
        
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = houses[i];
                
                if (count >= C) {
                    return true;
                }
            }
        }
        
        return false;
    }

    static int sToi(String str){
        return Integer.parseInt(str);
    }
}