import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int res = 0;
        int tmp = 0;
        String num = "";
        Boolean isMinus = false;
        for (char t : str.toCharArray()) {
            if (Character.isDigit(t)) {
                num += t;
            }

            if (t == '+') {
                if (isMinus) {
                    tmp += Integer.parseInt(num);
                    num = "";
                } else {
                    res += Integer.parseInt(num);
                    num = "";
                }
            } else if (t == '-') {
                if (isMinus) {
                    tmp += Integer.parseInt(num);
                    res -= tmp;
                    tmp = 0;
                    num = "";
                    isMinus = true;
                } else {
                    res += Integer.parseInt(num);
                    num = "";
                    isMinus = true;
                }
            }
        }

        if (isMinus) {
            tmp += Integer.parseInt(num);
            res -= tmp;
        } else {
            res += Integer.parseInt(num);
        }

        System.out.println(res);
    }
}
