import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Bosuck[] bosucks = new Bosuck[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bosucks[i] = new Bosuck(m, v);
        }

        Arrays.sort(bosucks);

        int[] C = new int[K];
        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long res = 0;
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && bosucks[j].m <= C[i]) {
                pq.offer(bosucks[j++].v);
            }
 
            if (!pq.isEmpty()) {
                res += pq.poll();
            }
        }
        System.out.println(res);
    }

    public static class Bosuck implements Comparable<Bosuck> {
        int m;
        int v;
        public Bosuck(int m, int v) { this.m = m; this.v = v; }

        @Override
        public int compareTo(Bosuck o) {
            return this.m - o.m; // 무게 오름차순
        }
    }
}
