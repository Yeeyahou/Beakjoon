import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[11];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = sToi(br.readLine());

        for (int i = 1; i <= 10; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 10; j++) {
                dp[j] = (dp[j] + dp[j-1]) % 10007;
            }
        }

        System.out.println(dp[10]);
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}
