import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[] nums;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        nums = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        setPalin(); // 모든 팰린드롬 설정하기
        
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] + "\n");
        }

        System.out.println(sb);
    }

    static void setPalin() {
        for (int i = 1; i <= n; i++) { // 문자열 1개일땐 무조건 팰린드롬
            dp[i][i] = 1;
        }
        for (int i = 1; i <= n - 1; i++) { // 문자열 2개일때 둘이 같아야 팰린
            if (nums[i] == nums[i + 1])
                dp[i][i + 1] = 1;
        }
        for (int i = 3; i <= n; i++) { // 문자열 3개이상일때 양 끝이 같고 사이의 문자열이 팰린이면 팰린
            for (int j = 1; j <= n - i + 1; j++) {
                if (nums[j] == nums[j + i - 1] && dp[j + 1][j + i - 2] == 1) {
                    dp[j][j + i - 1] = 1;
                }
            }
        }
    }
}
