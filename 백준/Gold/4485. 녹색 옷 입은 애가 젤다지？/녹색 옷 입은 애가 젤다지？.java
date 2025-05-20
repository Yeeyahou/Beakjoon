import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int sToi(String s) {
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = 1;
        while(true){
            int n = sToi(br.readLine());
            if(n == 0) break;
            int[][] arr = new int[n+1][n+1];
            int[][] rupee = new int[n+1][n+1];

            for(int i = 1; i <= n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                Arrays.fill(rupee[i], Integer.MAX_VALUE);
                for(int j = 1; j <= n; j++){
                    arr[i][j] = sToi(st.nextToken());
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
            pq.add(new Node(1, 1, arr[1][1]));
            rupee[1][1] = arr[1][1];

            // 다익스트라
            while(!pq.isEmpty()){
                Node cur = pq.poll();

                int[] px = {-1, 0, 1, 0};
                int[] py = {0, -1, 0, 1};
                for(int i = 0; i < 4; i++){
                    int nx = cur.x + px[i];
                    int ny = cur.y + py[i];

                    if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
                    if(rupee[nx][ny] > cur.cost + arr[nx][ny]){
                        rupee[nx][ny] = cur.cost + arr[nx][ny];
                        pq.add(new Node(nx, ny, rupee[nx][ny]));
                    }
                }
            }
            sb.append("Problem " + k + ": " + rupee[n][n]).append("\n");
            k++;
        }
        System.out.println(sb);
    }
}
