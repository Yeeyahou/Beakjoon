import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int board[][];
    static int dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dp(N - 1, M - 1));
    }

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    static int dp(int x, int y) {

        if (x == 0 && y == 0)
            return 1;

        if (dp[y][x] != -1)
            return dp[y][x];

        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (board[ny][nx] > board[y][x]) {
                    dp[y][x] += dp(nx, ny);
                }
            }
        }

        return dp[y][x];
    }
}
