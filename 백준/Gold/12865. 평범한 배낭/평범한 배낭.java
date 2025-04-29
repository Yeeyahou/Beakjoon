import java.util.*;
import java.io.*;

public class Main {
    static int[][]dp;
    static int[] W;
    static int[] V;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) + 1;
        
        dp = new int[N+1][K+1];
        W = new int[N+1];
        V = new int[N+1];

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= K; j++){
                dp[i][j] = -1;
            }
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(N, K));
    }

    static int solve(int n, int weight){
        if(weight <= 0) return - 99999;
        if(n == 0) return 0;

        if(dp[n][weight] != -1) return dp[n][weight];
      
        return dp[n][weight] = Math.max(solve(n-1,weight),solve(n-1,weight-W[n]) + V[n]);
    }
}