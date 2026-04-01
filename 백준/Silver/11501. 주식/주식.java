import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int arr[] = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }

            long res = 0;
            int maxPrice = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (arr[j] > maxPrice) {
                    maxPrice = arr[j];
                } else {
                    res += (maxPrice - arr[j]);
                }
            }
            System.out.println(res);
        }
    }
}
