import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];
        dp[0] = 1; //고정값
        int [] coin = new int[n];

        for(int i = 0; i < n ; i++){
            coin[i] =  Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n ; i++){
            for(int j = coin[i]; j <= k; j++){
                dp[j] = dp[j] + dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
