import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        matrix = new int[n][2];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(cal(0,n-1));
    }

    static int cal(int i, int j) {
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k = i ; k < j; k++){
            int dpRes = cal(i ,k) + cal(k + 1,j) + matrix[i][0] * matrix[k][1] * matrix[j][1];
            min = Math.min(min, dpRes);
        }

        return dp[i][j] = min;
    }

}
