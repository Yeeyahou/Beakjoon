import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(v);
        stack.push(v);
        boolean[][] arr = new boolean[n+1][n+1];
        boolean[] visitedDFS = new boolean[n+1];
        boolean[] visitedBFS = new boolean[n+1];
        //visitedDFS[v] = true;
        //visitedBFS[v] = true;

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = true;
            arr[y][x] = true;
        }

        while(!stack.isEmpty()){
            int num = stack.pop();
            if(visitedDFS[num]) continue;
            visitedDFS[num] = true;
            sb.append(num + " ");
            for(int i = n; i >= 1; i--){
                if(arr[num][i]  && !visitedDFS[i]){
                    stack.push(i);
                    
                }
            }
        }
        System.out.println(sb);
        sb.setLength(0);

        while(!queue.isEmpty()){
            int num = queue.poll();
            if(visitedBFS[num]) continue;
            visitedBFS[num] = true;
            sb.append(num + " ");
            for(int i = 1; i <= n; i++){
                if(arr[num][i]  && !visitedBFS[i]){
                    queue.add(i);
                }
            }
        }
        System.out.println(sb);
    }
}