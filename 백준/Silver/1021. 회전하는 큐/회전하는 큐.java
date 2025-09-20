import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = sToi(st.nextToken());
        int M = sToi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> targets = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            targets.add(sToi(st.nextToken()));
        }

        // 양방향 큐
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int res = 0;
        for (int target : targets) {
            int idx = queue.indexOf(target);
            int n = queue.size();
            
            int l = idx;
            int r = n - idx;
            int m = Math.min(l, r);
            
            res += m;
            
            while (queue.getFirst() != target) {
                if (l <= r) {
                    queue.addLast(queue.removeFirst());
                } else {
                    queue.addFirst(queue.removeLast());
                }
            }
            queue.removeFirst();
        }
        
        System.out.println(res);
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}