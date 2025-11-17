import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            count.put(book, count.getOrDefault(book, 0) + 1);
        }

        String res = null;
        int max = 0;
        for (String t : count.keySet()) {
            int c = count.get(t);
            if (c > max) {
                max = c;
                res = t;
            } else if (c == max) {
                if (res == null || t.compareTo(res) < 0) {
                    res = t;
                }
            }
        }

        System.out.println(res);
    }
}
