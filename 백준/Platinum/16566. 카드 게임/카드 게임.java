import java.io.*;
import java.util.*;

public class Main {
    static int[] cards;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        cards = new int[M];
        parent = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);
        for (int i = 0; i <= M; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            int idx = upperBound(num);
            int resIdx = find(idx);
            sb.append(cards[resIdx]).append("\n");
            parent[resIdx] = find(resIdx + 1); // 사용한 카드 skip
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static int upperBound(int target) {
        int left = 0, right = cards.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
