import java.io.*;
import java.util.*;

public class Main {
    static class Tomato {
        int x, y;

        public Tomato(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Tomato tomato = (Tomato) obj;
            return x == tomato.x && y == tomato.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Tomato> queue = new LinkedList<>();
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int num = Integer.parseInt(st.nextToken());
                Tomato tomato = new Tomato(i, j);
                if (num == 0) {
                } else if (num == 1) {
                    queue.add(tomato);
                } else if (num == -1) {

                }
                arr[i][j] = num;
            }
        }

        int day = 1;
        int[] x = { 0, 1, 0, -1 };
        int[] y = { -1, 0, 1, 0 };
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = t.x + x[i];
                int yy = t.y + y[i];
                if (xx >= 1 && xx <= m && yy >= 1 && yy <= n) { // 유효좌표 검사
                    if (arr[yy][xx] == 0) {
                        queue.add(new Tomato(yy, xx));
                        arr[yy][xx] = arr[t.y][t.x] + 1;
                        day = Math.max(day, arr[yy][xx]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day - 1);
    }
}