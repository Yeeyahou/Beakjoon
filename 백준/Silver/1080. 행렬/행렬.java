import java.io.*;
import java.util.*;

public class Main {
    static char[][] a;
    static char[][] b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = sToi(st.nextToken());
        int m = sToi(st.nextToken());

        a = new char[n + 1][m + 1];
        b = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            char[] t = ("0" + br.readLine()).toCharArray();
            a[i] = t;
        }
        for (int i = 1; i <= n; i++) {
            char[] t = ("0" + br.readLine()).toCharArray();
            b[i] = t;
        }

        if (n < 3 || m < 3) {
            if (isAllSame(n, m)) {
                System.out.println(0);
                return;
            } else {
                System.out.println(-1);

                return;
            }
        }

        int cnt = 0;
        for (int i = 1; i + 2 <= n; i++) {
            for (int j = 1; j + 2 <= m; j++) {
                if (a[i][j] != b[i][j]) {
                    change(i, j);
                    cnt++;
                }
            }
            if (!isSame(i, m)) {
                System.out.println(-1);
                return;
            }
        }
        for (int i = n - 1; i <= n; i++) {
            if (!isSame(i, m)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);
    }

    static boolean isSame(int n, int m) {
        for (int i = 1; i <= m; i++) {
            if (a[n][i] != b[n][i])
                return false;
        }
        return true;
    }

    static void change(int i, int j) {
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                a[x][y] = (a[x][y] == '0') ? '1' : '0';
            }
        }
    }

    static boolean isAllSame(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] != b[i][j])
                    return false;
            }
        }
        return true;
    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }
}
