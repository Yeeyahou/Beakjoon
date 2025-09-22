import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = sToi(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int k = sToi(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = sToi(st.nextToken());
                
                if (op.equals("I")) {
                    // 삽입 연산
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (op.equals("D")) {
                    if (map.isEmpty()) continue;
                    
                    if (num == 1) {
                        // 최댓값 삭제
                        int maxKey = map.lastKey();
                        if (map.get(maxKey) == 1) {
                            map.remove(maxKey);
                        } else {
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    } else if (num == -1) {
                        // 최솟값 삭제
                        int minKey = map.firstKey();
                        if (map.get(minKey) == 1) {
                            map.remove(minKey);
                        } else {
                            map.put(minKey, map.get(minKey) - 1);
                        }
                    }
                }
            }
            
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }

    static int sToi(String str){
        return Integer.parseInt(str);
    }
}