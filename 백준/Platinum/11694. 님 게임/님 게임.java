    import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = sToi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isAllOne = true;
        int grundy = 0;

        for (int i = 0; i < n; i++) {
            int num = sToi(st.nextToken());
            if (num != 1) isAllOne = false;
            grundy ^= num;
        }

        if (isAllOne) {
            System.out.println(n % 2 == 0 ? "koosaga" : "cubelover");
        } else {
            System.out.println(grundy == 0 ? "cubelover" : "koosaga");
        }
    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }
}
