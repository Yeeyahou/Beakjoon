import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 작은 수 먼저 나가는 우선순위 큐
        PriorityQueue<Long> maxHeap = new PriorityQueue<>();

        int n = sToi(br.readLine());
        long viewCount = 0;

        for (int i = 0; i < n; i++) {
            long viewer = 0;
            long current = sToi(br.readLine());
            while (maxHeap.size() > 0) {
                if (maxHeap.peek() <= current)
                    maxHeap.poll();
                else
                    break;
            }
            viewer = maxHeap.size();
            viewCount += viewer;
            maxHeap.offer(current);
        }

        System.out.print(viewCount);
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}
