import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        for (int i = 0; i < r   ; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        int res = 0;
        for (int rr = 0; rr < r; rr++) {
            for (int cc = 0; cc < c; cc++) {
                if (map[rr][cc] == 'L') {
                    res = Math.max(res, bfs(rr, cc, map, r, c));
                }
            }
        }
        System.out.println(res);
    }

    static int bfs(int sr, int sc, char[][] map, int R, int C) {
        int[][] dist = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(dist[i], -1);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        dist[sr][sc] = 0;
        int maxd = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (map[nr][nc] != 'L' || dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;
                maxd = Math.max(maxd, dist[nr][nc]);
                q.add(new int[]{nr, nc});
            }
        }
        return maxd;
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}     