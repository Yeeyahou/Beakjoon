import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] palin;
    static int[] dp;
    static char[] str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = (" " + br.readLine()).toCharArray(); // 입력 받은 문자의 인덱스가 1부터 시작하도록 맞춤

        int n = str.length;
        palin = new boolean[n][n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        setPalin(); // 모든 팰린드롬 설정하기

        System.out.println(solve(n - 1));
    }

    static int solve(int n) {

        if (n == 0)
            return 0;
        if (dp[n] != Integer.MAX_VALUE)
            return dp[n];

        for (int i = 1; i <= n; i++) {
            if (palin[i][n]) {
                dp[n] = Math.min(dp[n], solve(i - 1) + 1);
            }
        }
        return dp[n];
    }

    static void setPalin() {
        for (int i = 1; i < str.length; i++) { // 문자열 1개일땐 무조건 팰린드롬
            palin[i][i] = true;
        }
        for (int i = 1; i < str.length - 1; i++) { // 문자열 2개일때 둘이 같아야 팰린
            if (str[i] == str[i + 1])
                palin[i][i + 1] = true;
        }
        for (int i = 3; i < str.length; i++) { // 문자열 3개이상일때 양 끝이 같고 사이의 문자열이 팰린이면 팰린
            for (int j = 1; j <= str.length - i; j++) {
                if (str[j] == str[j + i - 1] && palin[j + 1][j + i - 2]) {
                    palin[j][j + i - 1] = true;
                }
            }
        }
    }
}
