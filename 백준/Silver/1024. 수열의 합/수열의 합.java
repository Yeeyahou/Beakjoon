import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        for (int i = L; i <= 100; i++){
            //등차수열 중앙값에서 빼야 하는 수(등차수열 시작 수 구하기): (int)Math.ceil(L/2) - 1;
            int s = (int)Math.ceil(i/2.0) - 1;
            int startNum = (N/i) - s;
            if(startNum < 0) break;
                int sum = (i*(startNum*2 + i - 1))/2;
            if(sum == N){
                for(int j = 0; j < i; j++){
                    System.out.print(startNum + j);
                    if(j != i-1) System.out.print(" ");
                }
                return;
            }
        }

        System.out.println(-1);
    }
}
