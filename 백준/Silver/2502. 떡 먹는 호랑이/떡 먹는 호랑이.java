import java.util.*;
import java.io.*;

public class Main {
    static class DDUG{
        int d1,d2;
        public DDUG(int a,int b){
            d1 = a;
            d2 = b;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        DDUG[] dug = new DDUG[d];
        dug[0] = new DDUG(1, 0);
        dug[1] = new DDUG(0, 1);

        for(int i = 2; i < d;i++){
            int d1 = dug[i-2].d1 + dug[i-1].d1;
            int d2 = dug[i-2].d2 + dug[i-1].d2;
            dug[i] = new DDUG(d1, d2);
        }

        int n1 = dug[d-1].d1;
        int n2 = dug[d-1].d2;

        int i = 1;
        while (true) {
            int num = k-(i*n1);
            if( num % n2 == 0){
                System.out.println(i);
                System.out.println((num / n2));
                return;
            }
            i++;
        }
    }
}
