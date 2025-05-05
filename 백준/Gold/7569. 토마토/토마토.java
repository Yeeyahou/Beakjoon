import java.io.*;
import java.util.*;

public class Main {
    static class Tomato {
        int x, y, z;

        public Tomato(int z, int y, int x) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object obj) {
            Tomato tomato = (Tomato) obj;
            return x == tomato.x && y == tomato.y && z == tomato.z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Tomato> queue = new LinkedList<>();
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] arr = new int[h + 1][n + 1][m + 1];

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= m; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    Tomato tomato = new Tomato(i, j, k);
                    if (num == 0) {
                    } else if (num == 1) {
                        queue.add(tomato);
                    } else if (num == -1) {

                    }
                    arr[i][j][k] = num;
                }
            }
        }

        int day = 1;
        int[] x = { 0, 1, 0, -1, 0, 0 };
        int[] y = { -1, 0, 1, 0, 0, 0 };
        int[] z = { 0, 0, 0, 0, 1, -1 };

        while (!queue.isEmpty()) {
            Tomato t = queue.poll();

            for (int i = 0; i < 6; i++) {
                int xx = t.x + x[i];
                int yy = t.y + y[i];
                int zz = t.z + z[i];
                if (xx >= 1 && xx <= m && yy >= 1 && yy <= n && zz >= 1 && zz <= h) { // 유효좌표 검사
                    if (arr[zz][yy][xx] == 0) {
                        queue.add(new Tomato(zz, yy, xx));
                        arr[zz][yy][xx] = arr[t.z][t.y][t.x] + 1;
                        day = Math.max(day, arr[zz][yy][xx]);
                    }
                }
            }
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(day - 1);
    }
}