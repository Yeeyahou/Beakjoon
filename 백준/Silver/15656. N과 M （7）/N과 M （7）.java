import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] input;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = sToi(st.nextToken());
        int m = sToi(st.nextToken());
        arr = new int[m];
        input = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = sToi(st.nextToken());
        }
        Arrays.sort(input);
        Arrays.sort(arr);

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
            arr[depth] = input[i];
            bfs(n, m, depth + 1);
        }
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}
