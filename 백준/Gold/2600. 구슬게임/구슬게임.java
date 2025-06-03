import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp; // -1 패배, 0 미정, 1 승리
    static int[] b = new int[3];
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        b = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] k1 = new int[5];
        int[] k2 = new int[5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k1[i] = sToi(st.nextToken());
            k2[i] = sToi(st.nextToken());
            n = Math.max(k1[i], n);
            n = Math.max(k2[i], n);
        }

        dp = new int[n + 1][n + 1];

        for (int i = 0; i < 5; i++) {
            int res = solve(k1[i], k2[i]);
            if (res == 1)
                System.out.println("A");
            else if (res == -1)
                System.out.println("B");
            else
                System.out.println("Fuck");
        }
    }

    static int solve(int i, int j) {
        if (i < b[0] && j < b[0])
            return -1;
        if (dp[i][j] != 0)
            return dp[i][j];
        for (int k = 0; k < 3; k++) {
            int res;
            if ((i - b[k]) >= 0) {
                res = solve(i - b[k], j);
                if (res == -1)
                    return dp[i][j] = dp[j][i] = 1;
            }
            if ((j - b[k]) >= 0) {
                res = solve(i, j - b[k]);
                if (res == -1)
                    return dp[i][j] = dp[j][i] = 1;
            }
        }
        return dp[i][j] = dp[j][i] = -1;
    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }
}
