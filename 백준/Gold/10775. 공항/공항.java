import java.io.*;
import java.util.*;

public class Main {
    static boolean[] gate;
    static int[] head;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = sToi(br.readLine());
        int p = sToi(br.readLine());

        gate = new boolean[g + 1];
        head = new int[g + 1];

        for (int i = 0; i < g; i++) {
            head[i + 1] = i + 1;
        }

        int cnt = 0;
        for (int i = 0; i < p; i++) {
            int n = sToi(br.readLine());
            if (docking(n)) {
                cnt++;
                continue;
            }
            break;
        }

        System.out.println(cnt);
    }

    static boolean docking(int n) {
        int k = find(n);
        if (k == 1 && gate[1])
            return false;
        if (!gate[k]) {
            gate[k] = true;
        } else {
            gate[k - 1] = true;
        }
        if (k != 1)
            head[k] = k - 1;

        return true;
    }

    static int find(int n) {
        if (head[n] == n)
            return n;
        return head[n] = find(head[n]);
    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }
}
