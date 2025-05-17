import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        System.out.println(solve(0, 0));
    }

    static int solve(int depth, int idx) {
        if (depth == n - 1)
            return arr[depth][idx];

        if (dp[depth][idx] != 0)
            return dp[depth][idx];

        return dp[depth][idx] = arr[depth][idx] + Math.max(solve(depth + 1, idx), solve(depth + 1, idx + 1));
    }

}