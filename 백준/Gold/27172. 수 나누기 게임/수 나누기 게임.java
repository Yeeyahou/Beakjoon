import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        public int x;
        public int y;
        int num;
        int distance = 0;

        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        Node(int num, int x, int y, int distance) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = sToi(br.readLine());
        int[] cards = new int[n+1];
        int[] scores = new int[n+1];
        int[] info = new int[1000005];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cards[i] = sToi(st.nextToken());
            info[cards[i]] = i;
        }

        for (int i = 1; i <= n; i++) {
            int num = cards[i];
            for(int j = num * 2; j <= 1000000; j += num) {
                if (info[j] != 0) {
                    scores[info[j]]--;
                    scores[i]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(scores[i] + " ");
        }
        System.out.println(sb);
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}
