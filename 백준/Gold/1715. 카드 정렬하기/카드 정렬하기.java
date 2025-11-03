import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = sToi(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sToi(br.readLine()));
        }

        long res = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int s = a + b;
            res += s;
            pq.add(s);
        }

        System.out.println(res);
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}