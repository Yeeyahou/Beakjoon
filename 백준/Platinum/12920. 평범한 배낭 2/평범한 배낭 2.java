import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 아이템 종류
        int M = Integer.parseInt(st.nextToken()); // 최대 무게

        dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 무게
            int c = Integer.parseInt(st.nextToken()); // 만족도
            int k = Integer.parseInt(st.nextToken()); // 개수

            // 이진 분할
            for (int j = 1; k > 0; j *= 2) {
                int count = Math.min(j, k);
                int weight = v * count;
                int value = c * count;

                for (int m = M; m >= weight; m--) {
                    dp[m] = Math.max(dp[m], dp[m - weight] + value);
                }
                k -= count;
            }
        }

        System.out.println(dp[M]);
    }
}