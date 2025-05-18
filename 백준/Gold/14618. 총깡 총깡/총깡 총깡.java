import java.io.*;
import java.util.*;

public class Main {
    static enum HouseType {
        A, B, NONE, ME
    }
    static class House{
        int number;
        int distance;
        HouseType type;
        public House(int number, int distance, HouseType type) {
            this.number = number;
            this.distance = distance;
            this.type = type;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = sToi(st.nextToken());
        int m = sToi(st.nextToken());
        int j = sToi(br.readLine());
        int k = sToi(br.readLine());

        List<House>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        HouseType[] houseTypes = new HouseType[n+1];
        Arrays.fill(houseTypes, HouseType.NONE);
        houseTypes[j] = HouseType.ME;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= k; i++) {
            int num = sToi(st.nextToken());
            houseTypes[num] = HouseType.A;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= k; i++) {
            int num = sToi(st.nextToken());
            houseTypes[num] = HouseType.B;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = sToi(st.nextToken());
            int b = sToi(st.nextToken());
            int c = sToi(st.nextToken());
            
            graph[a].add(new House(b, c, houseTypes[b]));
            graph[b].add(new House(a, c, houseTypes[a]));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[j] = 0;

        int minDist = Integer.MAX_VALUE;
        HouseType minType = HouseType.NONE;
        PriorityQueue<House> pq = new PriorityQueue<>((h1, h2) ->{
            return h1.distance - h2.distance;
        });
        pq.add(new House(j, 0, HouseType.ME));

        while(!pq.isEmpty()){
            House cur = pq.poll();
            if(cur.distance > dist[cur.number]) continue;

            for(House next : graph[cur.number]){
                int newDist = cur.distance + next.distance;
                if(newDist < dist[next.number]){
                    dist[next.number] = newDist;
                    pq.add(new House(next.number, newDist, next.type));
                }

                if(next.type == HouseType.NONE || next.type == HouseType.ME) continue;
                if(newDist < minDist){
                    minDist = newDist;
                    minType = next.type;
                }
                else if(newDist == minDist && next.type == HouseType.A){
                    minDist = newDist;
                    minType = next.type;
                }
            }
        }

        if(minDist == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(minType);
            System.out.println(minDist);
        }
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}
