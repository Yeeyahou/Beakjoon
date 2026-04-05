import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = sToi(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int grundy = sToi(st.nextToken());
        arr[0] = grundy;
        for (int i = 1; i < n; i++) {
            arr[i] = sToi(st.nextToken());
            grundy ^= arr[i];
        }

        int res = 0;
        if (grundy == 0) {
            System.out.println(res);
            return;
        }

        for (int i = 0; i < n; i++) {
            int b = grundy ^ arr[i];
            if (b < arr[i])
                res++;
        }

        System.out.println(res);
    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }
}
