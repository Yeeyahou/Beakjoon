import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                return;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a[] = new int[n];
            a[0] = Integer.parseInt(st.nextToken());
            int grundy = a[0];

            for (int i = 1; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                grundy ^= a[i];
            }
            if (grundy == 0) {
                System.out.println(0);
                continue;
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if ((grundy ^ a[i]) < a[i])
                    res++;
            }
            System.out.println(res);
        }
    }
}
