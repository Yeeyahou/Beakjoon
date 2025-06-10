import java.io.*;
import java.util.*;

public class Main {
    static int[] grundy = new int[1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grundy[0] = 0;
        grundy[1] = 0;
        grundy[2] = 1;

        for (int i = 3; i <= n; i++) {
            char[] check = {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'};
            for (int j = 0; j < i / 2; j++) {
                int num = grundy[j] ^ grundy[i - 2 - j];
                check[num] = '1';
            }
            grundy[i] = new String(check).indexOf("0");
        }

        System.out.println((grundy[n] == 0) ? 2 : 1);
    }
    static int sToi(String str){
        return Integer.parseInt(str);
    }
}
