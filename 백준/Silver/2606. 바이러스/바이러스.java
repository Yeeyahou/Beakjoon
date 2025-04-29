import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n+1][n+1];
        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = true;
            arr[y][x] = true;

        }

        queue.add(1);
        visited.add(1);
        int res = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for(int i = 1 ; i <=n ; i++){
                if(arr[num][i] == true && (!visited.contains(i))){
                    visited.add(i);
                    queue.add(i);
                    res++;
                }
            }
        }

        

        System.out.println(res);
    }
}