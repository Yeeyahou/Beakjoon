import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        dp = new int[12];
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            
            int res = cal(n);
            sb.append(res + "\n");
        }

        System.out.println(sb);
    }

    static int cal(int i) {
        if(i == 1) return 1;
        if(i == 2) return 2;
        if(i == 3) return 4;
        

        if(dp[i] != 0) return dp[i];

        return dp[i] = cal(i-3) + cal(i-2) + cal (i-1);
    }

}
