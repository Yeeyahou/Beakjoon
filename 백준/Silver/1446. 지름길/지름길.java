import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int location;
        int distance;

        public Node(int location, int distance) {
            this.distance = distance;
            this.location = location;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken()); // 목적지 거리

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= end; i++) {
            graph.add(new ArrayList<>());

            if(i < end) graph.get(i).add(new Node(i+1, 1));
        }

        int[] distance = new int[end + 1];
        Arrays.fill(distance, 100000);
        distance[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.distance, o2.distance);
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b <= end) { //목적지보다 멀리 가지 않으면 그래프에 추가
                graph.get(a).add(new Node(b, c));
            }
        }
        
        pq.add(new Node(0,0));

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            for(Node node : graph.get(nowNode.location)){
                int nowDistance = nowNode.distance + node.distance;
                if(distance[node.location] > nowDistance){ //새 경로가 기존 경로보다 작으면 업데이트 후 큐에 삽입
                    distance[node.location] = nowDistance;
                    pq.add(new Node(node.location, nowDistance));
                }
            }
        }

        System.out.println(distance[end]);
    }
}