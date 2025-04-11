import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        dp = new int[N][3];
        int tmp;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if (i == 0) {
                dp[i][0] = Integer.parseInt(st.nextToken());
                dp[i][1] = Integer.parseInt(st.nextToken());
                dp[i][2] = Integer.parseInt(st.nextToken());
                continue;
            }
            tmp = Integer.parseInt(st.nextToken());
            dp[i][0] = Math.min(tmp + dp[i-1][1], tmp + dp[i-1][2]);

            tmp = Integer.parseInt(st.nextToken());
            dp[i][1] = Math.min(tmp + dp[i-1][0], tmp + dp[i-1][2]);

            tmp = Integer.parseInt(st.nextToken());
            dp[i][2] = Math.min(tmp + dp[i-1][0], tmp + dp[i-1][1]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(dp[N-1][i], res);
        }
        System.out.println(res);
    }
}