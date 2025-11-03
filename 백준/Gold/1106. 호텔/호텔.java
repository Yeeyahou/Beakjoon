import java.io.*;
import java.util.*;

public class Main {

    static int[] prices;
    static int[] customers;
    static int[][] dp;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int goal = sToi(st.nextToken());
        int n = sToi(st.nextToken());

        prices = new int[100000];
        customers = new int[100000];

        int realIndex = 1;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = sToi(st.nextToken());
            int c = sToi(st.nextToken());
            for(int j = 0; j < goal / c + 1; j++) {
                prices[realIndex] = p;
                customers[realIndex] = c;
                realIndex++;
            }
        }

        dp = new int[realIndex][goal + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(realIndex - 1, goal));
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }

    // n: 사용할 수 있는 아이템 인덱스(1..realIndex-1)
    // need: 남은 확보할 고객 수
    static int solve(int n, int need) {
        if (need <= 0) return 0; // 이미 충분하면 비용 0
        if (n == 0) return INF;  // 아이템 다 쓰면 불가능(큰 비용)
        if (dp[n][need] != -1) return dp[n][need];

        int without = solve(n - 1, need);

        int withCost = solve(n - 1, Math.max(0, need - customers[n])) +  prices[n];

        int res = Math.min(without, withCost);
        dp[n][need] = res;
        return res;
    }
}