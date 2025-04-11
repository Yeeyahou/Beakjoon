import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[2][n];
            arr = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp[0][i] = arr[0][i];
                    dp[1][i] = arr[1][i];
                    continue;
                }
                
                if(i==1){
                    dp[0][i] = arr[0][i] + dp[1][i-1];
                    dp[1][i] = arr[1][i] + dp[0][i-1];
                    continue;
                }
                dp[0][i] = arr[0][i] + Math.max(Math.max(dp[0][i-2], dp[1][i-2]), dp[1][i-1]);
                dp[1][i] = arr[1][i] + Math.max(Math.max(dp[0][i-2], dp[1][i-2]), dp[0][i-1]);
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}