import java.io.*;
import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }

        // 1. +, - 버튼만 눌러서 이동
        int answer = Math.abs(target - 100);

        // 2. 숫자 버튼 + +,-로 이동하는 방법 확인
        for (int i = 0; i <= 999999; i++) {
            int len = check(i);
            if (len > 0) { // i번 채널을 누를 수 있다면
                int press = len + Math.abs(i - target); // 숫자버튼 누른 횟수 + 이동
                answer = Math.min(answer, press);
            }
        }

        System.out.println(answer);
    }

    // 누를 수 있는 숫자인지 확인
    static int check(int n) {
        if (n == 0) {
            return broken[0] ? 0 : 1;
        }

        int len = 0;
        while (n > 0) {
            if (broken[n % 10]) return 0;
            n /= 10;
            len++;
        }
        return len;
    }
}
