import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int arr[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(st.nextToken());
            sum += arr[i + 1];
        }

        boolean able[] = new boolean[sum + 1];
        for (int i = 1; i < Math.pow(2, n); i++) {
            int cnt = 0;
            int selected[] = new int[n + 1];
            for (int bit = 0; bit < n; bit++) {
                if ((i & (1 << bit)) != 0) {
                    selected[cnt++] = arr[bit + 1];
                }
            }
            for (int j = 0; j < (1 << cnt); j++) {
                int idx = 0;
                for (int k = 0; k < cnt; k++) {
                    if ((j & (1 << k)) != 0) {
                        idx += selected[k];
                    } else {
                        idx -= selected[k];
                    }
                }
                able[Math.abs(idx)] = true;
            }
        }
        int res = 0;
        for (int i = 1; i <= sum; i++) {
            if (!able[i]) {
                res++;
            }
        }
        System.out.println(res);
    }
}