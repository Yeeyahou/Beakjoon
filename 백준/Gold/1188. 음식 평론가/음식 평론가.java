import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 소시지 수
        int m = Integer.parseInt(st.nextToken()); // 평론가 수
        int res = 0;

        // 소시지가 사람보다 많으면 사람수의 배수만큼의 소시지는 자를 필요가 없어서 그 만큼 빼줌
        n -= (n / m) * m;
        if (n == 0) {
            System.out.println(0);
            return;
        }

        if (m % n == 0) {
            res = n * (m / n - 1);
            System.out.println(res);
            return;
        }

        res = n * (m / n);
        int piece = (m - (m / n) * n);
        int p = (piece -1) - (gcd(n,piece) -1);
        res += p;
        System.out.println(res);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}