import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        System.out.println(calSum(end) - calSum(start - 1));
    }

    static Long calSum(long n) {
        if (n == 0 || n == -1)
            return (long) 0;
        // n의 자릿수 구하기
        int digit = String.valueOf(n).length();
        long res = 0;
        long dNum = 1; // 1, 10, 100, 1000...등의 자리의 기준 수
        for (int i = 0; i < digit; i++) {
            // step 1
            long s1 = (n / (dNum * 10)) * 45 * dNum;
            // step 2
            long tmp = (n % (dNum * 10)) / dNum; // 현재 dNum이 해당하는 자리의 숫자
            long s2 = sumTo((int) tmp - 1) * dNum;
            // step 3
            long s3 = tmp * (n % dNum + 1);

            res += s1 + s2 + s3;
            dNum *= 10;
        }

        return res;
    }

    static int sumTo(int n) {
        if (n < 0) return 0;
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 6;
            case 4:
                return 10;
            case 5:
                return 15;
            case 6:
                return 21;
            case 7:
                return 28;
            case 8:
                return 36;
            case 9:
                return 45;
            default:
                return -1;
        }
    }
}
