import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                if (c == 'Y') {
                    arr[i][j] = true;
                }
            }
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            Queue<Integer> queue = new LinkedList<>();
            ArrayList<Integer> visited = new ArrayList<>();
            visited.add(i);
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == true) {
                    tmp++;
                    queue.add(j);
                    visited.add(j);
                }
            }
            int qn = queue.size();
            for (int j = 0; j < qn; j++) {
                int num = queue.poll();
                for (int k = 0; k < n; k++) {
                    if (arr[num][k] == true && !visited.contains(k)) {
                        tmp++;
                        visited.add(k);
                    }
                }
            }

            res = Math.max(res, tmp);
        }

        System.out.println(res);
    }
}
