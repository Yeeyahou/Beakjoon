import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] ground = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[y][x] = 1;
            }

            int wormCount = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (ground[y][x] == 1 && !visited[y][x]) {
                        bfs(x, y, ground, visited, M, N);
                        wormCount++;
                    }
                }
            }

            System.out.println(wormCount);
        }
    }

    static void bfs(int sx, int sy, int[][] ground, boolean[][] visited, int M, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sy][sx] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (ground[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
