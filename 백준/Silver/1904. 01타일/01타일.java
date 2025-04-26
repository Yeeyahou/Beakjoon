import java.util.*;
import java.io.*;

public class Main {
    static int[]dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(solve(n));
    }

    static int solve(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        if(dp[n] != 0) return dp[n];

        return dp[n] = (solve(n-1) + solve(n-2))%15746;
    }
}