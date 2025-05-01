import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        Node first = new Node(0, 0);
        queue.add(first);
        visited[0][0] = true;
        int [] x = {0,1,0,-1};
        int [] y = {-1,0,1,0};
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for(int i = 0; i < 4;i++){
                int px = now.x + x[i];
                int py = now.y + y[i];
                if(px >= 0 && px <= m-1 && py >= 0 && py <= n-1){ //유효한 좌표
                    if(visited[py][px] == false && maze[py][px] == 1){ //방문 안하고 칸이 1이면
                        queue.add(new Node(px, py));
                        visited[py][px] = true;
                        maze[py][px] = maze[now.y][now.x] + 1;
                    }
                }
            }
        }

        System.out.println(maze[n-1][m-1]);
    }
}
