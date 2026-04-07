import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int board[] = new int[n];
        int dp[][] = new int[2][n];

        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(board[0]);
            return;
        }

        // 기본 값 넣기
        dp[0][0] = dp[1][0] = board[0];
        dp[0][1] = board[0] + board[1];
        dp[1][1] = board[1];

        for (int i = 2; i < n; i++) {
            dp[0][i] = dp[1][i-1] + board[i];
            dp[1][i] = Math.max(dp[0][i-2],dp[1][i-2]) + board[i]; 
        }

        System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
    }
}
