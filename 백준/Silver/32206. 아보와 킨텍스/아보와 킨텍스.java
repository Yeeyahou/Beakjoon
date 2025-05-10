import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char prev = ' ';
        int consNum = 0;
        for (char c : str.toCharArray()) {
            if (c == prev)
                consNum++;
            else
                prev = c;
        }

        int res = 25 * (n + 1) + 1;
        System.out.println(res);
    }
}