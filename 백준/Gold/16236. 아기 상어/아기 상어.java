import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static PriorityQueue<Fish> queue = new PriorityQueue<>((o1, o2) -> {
        if (o1.distance != o2.distance)
            return Integer.compare(o1.distance, o2.distance);
        if (o1.y != o2.y)
            return Integer.compare(o1.y, o2.y);
        return Integer.compare(o1.x, o2.x);
    });

    static class Fish {
        public int x, y;
        public int distance = 10000;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        int sharkX = 0;
        int sharkY = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    sharkX = j;
                    sharkY = i;
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = num;
            }
        }

        int size = 2;
        int exp = 0;
        int res = 0;
        while (true) {
            if (move(sharkX, sharkY, size)) {
                exp++;
                if (size == exp) {
                    size++;
                    exp = 0;
                }
                Fish nearFish = queue.poll();
                res += nearFish.distance;
                arr[nearFish.y][nearFish.x] = 0;
                sharkX = nearFish.x;
                sharkY = nearFish.y;
            } else {
                break;
            }
        }
        System.out.println(res);
    }

    static boolean move(int sharkX, int sharkY, int size) {
        boolean[][] visited = new boolean[n + 1][n + 1];
        int[][] moveArr = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            moveArr[i] = arr[i].clone();
        }

        Queue<Fish> quest = new LinkedList<>();
        boolean resFlag = false;
        queue.clear();
        quest.add(new Fish(sharkX, sharkY, 0));
        visited[sharkY][sharkX] = true;
        moveArr[sharkY][sharkX] = 0;

        int[] x = { 1, -1, 0, 0 };
        int[] y = { 0, 0, 1, -1 };
        while (!quest.isEmpty()) {
            Fish now = quest.poll();

            for (int i = 0; i < 4; i++) {
                int xx = now.x + x[i];
                int yy = now.y + y[i];
                if (xx >= 1 && xx <= n && yy >= 1 && yy <= n) {
                    if (visited[yy][xx] == false && moveArr[yy][xx] <= size) {
                        visited[yy][xx] = true;
                        quest.add(new Fish(xx, yy, 0));
                        if (moveArr[yy][xx] != 0 && moveArr[yy][xx] < size) {
                            queue.add(new Fish(xx, yy, moveArr[now.y][now.x] + 1));
                            resFlag = true;
                        }
                        moveArr[yy][xx] = moveArr[now.y][now.x] + 1;

                    }
                }
            }
        }
        return resFlag;
    }
}