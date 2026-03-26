import java.io.BufferedInputStream;
import java.util.Arrays;

public class Main {
    private static class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        private int read() throws Exception {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        int nextInt() throws Exception {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        int[] intervalStart = new int[n];
        int[] intervalEnd = new int[n];
        int m = 0;

        for (int i = 0; i < n; i++) {
            int h = fs.nextInt();
            int o = fs.nextInt();
            int s = Math.min(h, o);
            int e = Math.max(h, o);
            intervalStart[m] = e;
            intervalEnd[m] = s;
            m++;
        }

        int d = fs.nextInt();

        int valid = 0;
        for (int i = 0; i < m; i++) {
            int e = intervalStart[i];
            int s = intervalEnd[i];
            if (e - s <= d) {
                intervalStart[valid] = e;
                intervalEnd[valid] = s + d;
                valid++;
            }
        }

        if (valid == 0) {
            System.out.println(0);
            return;
        }

        intervalStart = Arrays.copyOf(intervalStart, valid);
        intervalEnd = Arrays.copyOf(intervalEnd, valid);
        Arrays.sort(intervalStart);
        Arrays.sort(intervalEnd);

        int i = 0;
        int j = 0;
        int active = 0;
        int answer = 0;

        while (i < valid) {
            if (j >= valid || intervalStart[i] <= intervalEnd[j]) {
                active++;
                if (active > answer) {
                    answer = active;
                }
                i++;
            } else {
                active--;
                j++;
            }
        }

        System.out.println(answer);
    }
}
