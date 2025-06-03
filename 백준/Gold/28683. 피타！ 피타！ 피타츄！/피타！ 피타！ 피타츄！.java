import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = sToi(br.readLine());

        if (Math.sqrt(N) == (long)Math.sqrt(N)) {
            System.out.println(-1);
            return;
        }

        int cnt1 = 0;
        // N이 빗변인 경우: i^2 + j^2 = N
        for (long i = 1; i <= Math.sqrt(N / 2); i++) {
            long j = N - i * i;
            long sqrtJ = (long)Math.sqrt(j);
            if (sqrtJ * sqrtJ == j) {
                cnt1++;
            }
        }

        // N이 빗변이 아닌 경우: (B+A)(B-A) = N
        for (long i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                long a = i;
                long b = N / i;
                if ((a + b) % 2 == 0 && a != b) {
                    cnt1++;
                }
            }
        }

        System.out.println(cnt1);
    }

    static long sToi(String str) {
        return Long.parseLong(str);
    }
}
