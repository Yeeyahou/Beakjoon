import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = new int[ch2.length + 1][ch1.length + 1];

        for (int i = 1; i <= ch2.length; i++) {
            for (int j = 1; j <= ch1.length; j++) {
                char a = ch1[j - 1];
                char b = ch2[i - 1];
                if (a == b) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                        continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[ch2.length][ch1.length]);
    }
}
