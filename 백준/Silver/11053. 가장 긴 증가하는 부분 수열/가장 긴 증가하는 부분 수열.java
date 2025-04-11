import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        dp = new int[N];
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

        }
        int res = -1;
        for (int i = 0; i < N; i++) {
            res = Math.max(solve(i), res);
        }
        System.out.println(res);
    }

    static int solve(int n) {
        if (dp[n] == 0) {
            dp[n] = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (A[i] < A[n]) {
                    dp[n] = Math.max(dp[n], solve(i) + 1);
                }
            }
        }
        return dp[n];
    }

}