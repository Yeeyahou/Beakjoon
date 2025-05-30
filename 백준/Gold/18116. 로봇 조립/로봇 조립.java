import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1_000_001;
    static int[] robots = new int[MAX];
    static int[] parts = new int[MAX];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = sToi(br.readLine());

        for (int i = 1; i < MAX; i++) {
            parts[i] = 1;
            robots[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);

            if (c == 'I') {
                int a = sToi(st.nextToken());
                int b = sToi(st.nextToken());
                union(a, b);
            }
            if (c == 'Q') {
                int a = find(sToi(st.nextToken()));
                sb.append(parts[a] + "\n");
            }
        }

        System.out.println(sb);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        if(fa==fb) return;

        robots[fa] = fb;
        parts[fb] += parts[fa];
    }

    static int find(int n) {
        if (robots[n] == n)
            return n;
        return robots[n] = find(robots[n]);
    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }
}
