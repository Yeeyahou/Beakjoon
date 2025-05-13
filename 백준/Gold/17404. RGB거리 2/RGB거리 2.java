import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i][0] = num;
            num = Integer.parseInt(st.nextToken());
            arr[i][1] = num;
            num = Integer.parseInt(st.nextToken());
            arr[i][2] = num;
        }

        int res = 1000 * 1000; //최댓값
        for (int j = 0; j < 3; j++) {
            int[][] dp = new int[n][3];

            for (int i = 0; i < 3; i++){
                if(i == j) dp[0][i] = arr[0][i];
                else dp[0][i] = 1000 * 1000;
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
            
            for (int i = 0; i < 3; i++){
                if(i == j) continue;
                res = Math.min(res, dp[n-1][i]);
            }
        }

        System.out.println(res);
    }
}