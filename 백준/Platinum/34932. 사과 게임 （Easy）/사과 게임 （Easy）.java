import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        if ((N & 1) == 0) {
            System.out.println("Lulu");
            return;
        }

        long[] doubled = new long[2 * N];
        for (int i = 0; i < N; i++) {
            doubled[i] = arr[i];
            doubled[i + N] = arr[i];
        }

        long worstForTerra = Long.MAX_VALUE;
        int half = N / 2;

        for (int s = 0; s < N; s++) {
            long value = doubled[s];

            // For odd length, each mirrored pair contributes the absolute gap.
            for (int i = 1; i <= half; i++) {
                long left = doubled[s + i];
                long right = doubled[s + N - i];
                value += Math.abs(left - right);
            }

            worstForTerra = Math.min(worstForTerra, value);
        }

        System.out.println(worstForTerra > 0 ? "Terra" : "Lulu");
    }
}