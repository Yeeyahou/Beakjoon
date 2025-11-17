import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        int MAX = 9999999;
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[N] = 0;
        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.d != dist[cur.v]) continue;
            if (cur.v == K) break;

            int v = cur.v;
            // 텔포
            int nx = v * 2;
            if (nx <= MAX && dist[nx] > dist[v]) {
                dist[nx] = dist[v];
                pq.add(new Node(nx, dist[nx]));
            }
            // 그냥 이동
            nx = v - 1;
            if (nx >= 0 && dist[nx] > dist[v] + 1) {
                dist[nx] = dist[v] + 1;
                pq.add(new Node(nx, dist[nx]));
            }
            nx = v + 1;
            if (nx <= MAX && dist[nx] > dist[v] + 1) {
                dist[nx] = dist[v] + 1;
                pq.add(new Node(nx, dist[nx]));
            }
        }

        System.out.println(dist[K]);
    }
}

class Node implements Comparable<Node> {
    int v, d;
    Node(int v, int d){ 
        this.v = v; 
        this.d = d; 
    }

    public int compareTo(Node o){ return Integer.compare(this.d, o.d); }
}
