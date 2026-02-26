import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long resNum = 0;
        long tmpNum = N;
        for (int i = 0; i < K; i++){
            long num;
            if(i + 1 == K)
                num = getHigh(tmpNum);
            else
                num = getLow(tmpNum);

            resNum += num;
            tmpNum -= num;
        }

        System.out.println(resNum - N);
    }

    //n보다 작은 가장 큰 2의 제곱수 구하는 함수
    static long getLow(long n){
        long num = 1;
        while (n > num) {
            if (num *  2 > n) return num;
            num *= 2;
        }
        return 0;
    }
    //n이상의 가장 작은 2의 제곱 수 구하는 함수
    static long getHigh(long n){
        long num = 1;
        while (n > num) {
            if (num * 2 >= n) return num * 2;
            num *= 2;
        }
        return 1;
    }
}