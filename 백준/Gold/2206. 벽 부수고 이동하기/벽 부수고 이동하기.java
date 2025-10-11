import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board = new int[1001][1001];
    static int[][] visited = new int[1001][1001];
    static int[][] visited2 = new int[1001][1001];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = sToi(st.nextToken());
        M = sToi(st.nextToken());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        visited[0][0] = 1;
        bfs1(0, 0);

        int result = visited[N-1][M-1];
        if (visited2[N-1][M-1] != 0) {
            if (result == 0) result = visited2[N-1][M-1];
            else result = Math.min(result, visited2[N-1][M-1]);
        }
        
        if (result == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
    
    static void bfs1(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] != 0 && visited[nx][ny] <= visited[node.x][node.y] + 1) continue;
                visited[nx][ny] = visited[node.x][node.y] + 1;
                if (board[nx][ny] == 1) {
                    bfs2(nx, ny);
                }
                else{
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    static void bfs2(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited2[x][y] = visited[x][y]; // 벽을 부순 상태의 시작점 설정
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (board[nx][ny] == 1) continue;
                if (visited2[nx][ny] != 0 && visited2[nx][ny] <= visited2[node.x][node.y] + 1) continue;
                visited2[nx][ny] = visited2[node.x][node.y] + 1;
                q.add(new Node(nx, ny));
            }
        }
    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }
}
