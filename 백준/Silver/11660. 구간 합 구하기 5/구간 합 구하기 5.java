import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[][] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new int[n][n];
        nums = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int width = x2 - x1 + 1;

            int res = 0;
            for (int j = y1; j <= y2; j++) {
                res += (cal(j, x2) - cal(j, x2 - width));
            }
            sb.append(res + "\n");
        }

        System.out.println(sb);
    }

    static int cal(int i, int j) {
        if (j == -1) return 0;
        if (j == 0)
            return dp[i][0] = nums[i][0];

        if (dp[i][j] != 0)
            return dp[i][j];

        return dp[i][j] = cal(i, j - 1) + nums[i][j];
    }
}
