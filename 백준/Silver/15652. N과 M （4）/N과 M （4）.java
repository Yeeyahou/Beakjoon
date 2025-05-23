import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = sToi(st.nextToken());
        int m = sToi(st.nextToken());
        arr = new int[m];
        bfs(n, m, 0, 0);
        System.out.println(sb);
    }

    static void bfs(int n, int m, int depth, int at) {
        if (m == depth) {
            for (var num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < n; i++) {
            arr[depth] = i + 1;
            bfs(n, m, depth + 1, i);
        }
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}
