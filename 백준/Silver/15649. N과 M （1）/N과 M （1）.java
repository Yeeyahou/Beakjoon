import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = sToi(st.nextToken());
        int m = sToi(st.nextToken());
        arr = new int[m];
        used = new boolean[n];
        bfs(n, m, 0);
        System.out.println(sb);
    }

    static void bfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) { 
                used[i] = true;
                arr[depth] = i + 1;
                bfs(n, m, depth + 1);
                used[i] = false; 
            }
        }
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}
