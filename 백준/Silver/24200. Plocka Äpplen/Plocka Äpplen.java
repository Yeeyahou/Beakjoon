import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] grid;
    static boolean[][] visited;
    static int maxApples = 0;

    // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[2][N];
        visited = new boolean[2][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grid[0][i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grid[1][i] = Integer.parseInt(st.nextToken());
        }

        visited[1][0] = true;
        dfs(1, 0, 1, grid[1][0]);

        System.out.println(maxApples);
    }

    static void dfs(int r, int c, int count, int sum) {
        // 갱신
        maxApples = Math.max(maxApples, sum);

        // K번 모두 방문했으면 종료
        if (count == K) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < 2 && nc >= 0 && nc < N) {
                boolean alreadyVisited = visited[nr][nc];

                // 방문하지 않은 나무라면 사과를 더하고 방문 표시
                if (!alreadyVisited) {
                    visited[nr][nc] = true;
                    dfs(nr, nc, count + 1, sum + grid[nr][nc]);
                    visited[nr][nc] = false; //bt
                } else {
                    // 이미 방문한 나무 -> 이동만
                    dfs(nr, nc, count + 1, sum);
                }
            }
        }
    }
}