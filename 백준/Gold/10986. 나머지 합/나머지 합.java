import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long res = 0;
        long num = 0;
        long[] mod = new long[M]; //나머지 저장할 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num += Integer.parseInt(st.nextToken());
            mod[(int)(num % M)]++;
        }
        
        res = mod[0];
        for (int i = 0; i < M; i++) {
                res += combi(mod[i]);
        }
        System.out.println(res);
    }

    static long combi(long n){
        if (n < 2) {
            return 0; 
        }

        return (n * (n - 1)) / 2; // nC2 = n * (n - 1) / 2
    }
}
