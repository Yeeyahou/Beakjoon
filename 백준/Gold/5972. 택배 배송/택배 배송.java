import java.io.*;
import java.util.*;

public class Main {
    static class Cow  implements Comparable<Cow>{
        int num;
        int distance;

        public Cow(int a, int b) {
            num = a;
            distance = b;
        }

        @Override
        public int compareTo(Main.Cow o) {
            return this.distance - o.distance;
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        List<List<Cow>> mainList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            LinkedList<Cow> list = new LinkedList<>();
            mainList.add(list);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            mainList.get(a - 1).add(new Cow(b, c));
            mainList.get(b - 1).add(new Cow(a, c));
        }

        PriorityQueue<Cow> pq = new PriorityQueue<>();
        pq.add(new Cow(1, 0));

        while (!pq.isEmpty()) {
            Cow nowCow = pq.poll();
            if (visited[nowCow.num - 1] == true)
                continue;
            visited[nowCow.num - 1] = true;

            for (Cow cow : mainList.get(nowCow.num - 1)) {
                int nowDistance = nowCow.distance + cow.distance;
                if (distance[cow.num - 1] > nowDistance) {
                    distance[cow.num - 1] = nowDistance;
                        pq.add(new Cow(cow.num, nowDistance));
                }
            }
        }

        System.out.println(distance[n - 1]);
    }
}
