import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int res = 0;

        res += n/5;
        res += n/25;
        res += n/125;

        System.out.println(res);
    }
}
