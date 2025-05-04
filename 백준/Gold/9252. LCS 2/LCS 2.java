import java.io.*;

public class Main {
    static int[][] dp;
    static char[] s1, s2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s1 = (" " + br.readLine()).toCharArray();
        s2 = (" " + br.readLine()).toCharArray();

        int n = s1.length;
        int m = s2.length;
        dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s2[i] == s1[j])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m - 1, j = n - 1;
        while (i > 0 && j > 0) {
            if (s2[i] == s1[j]) {
                sb.append(s2[i]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else if (dp[i - 1][j] <= dp[i][j - 1]) {
                j--;
            }
        }

        System.out.println(dp[m - 1][n - 1]);
        if (sb.length() > 0)
            System.out.println(sb.reverse().toString());
    }
}