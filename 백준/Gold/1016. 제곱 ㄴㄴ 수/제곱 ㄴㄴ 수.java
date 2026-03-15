import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        long res = end - start + 1;

        boolean[] sieve = new boolean[(int)res];

        Arrays.fill(sieve, true);

        long i = 2;

        while (i * i <= end) {
            long sNum = start / (i * i);
            if (start % (i * i) != 0)
                sNum += 1;

            while (i*i*sNum <= end) {
                int index = (int)((i*i)*sNum -start);
                if(sieve[index]){
                    sieve[index] = false;
                    res --;
                }
                sNum++;
            }

            i ++;
        }

        System.out.println(res);
    }
}
