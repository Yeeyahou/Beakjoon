import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 소시지 수
        int m = Integer.parseInt(st.nextToken()); // 평론가 수

        // 정답은 평론가 수 - gcd(소시지 수, 평론가 수)
        int answer = m - gcd(n, m);

        System.out.println(answer);
    }

    // 유클리드 호제법
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
