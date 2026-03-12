import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t1[];
    static int t2[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = 1 << (k - 1);

        t1 = new int[n];
        t2 = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            t1[i] = Integer.parseInt(st1.nextToken());
            t2[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(solve(0, n - 1, 0, n - 1));
    }

    static int solve(int l1, int r1, int l2, int r2) {
        if (l1 == r1)
            return t1[l1] == t2[l2] ? 1 : 0;

        int mid1 = (l1 + r1) / 2;
        int mid2 = (l2 + r2) / 2;

        // 왼왼 + 오오 or 오왼 + 왼오
        int res1 = solve(l1, mid1, l2, mid2) + solve(mid1 + 1, r1, mid2 + 1, r2);
        int res2 = solve(mid1 + 1, r1, l2, mid2) + solve(l1, mid1, mid2 + 1, r2);

        return Math.max(res1, res2);

    }
}
