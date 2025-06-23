import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 3000001;
    static int[] arr = new int[MAX];
    static int[] dp = new int[32];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        for (int i = 4; i < MAX; i++) {
            boolean[] check = new boolean[16];
            int k = 0;
            while (dp[k] <= i) {
                check[arr[i - dp[k]]] = true;
                k++;
            }
            arr[i] = mex(check, 16);
        }

        int n = sToi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int grundy = 0;
        for (int i = 0; i < n; i++) {
            int k = sToi(st.nextToken());
            grundy ^= arr[k];
        }

        System.out.println((grundy == 0) ? "cubelover" : "koosaga");

    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }

    static int mex(boolean[] check, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                res = i;
                break;
            }
        }

        return res;
    }
}
