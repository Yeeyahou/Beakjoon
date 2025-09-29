import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 트리맵
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        int total = 0;
        while (sc.hasNextLine()) {
            String treeName = sc.nextLine();
            if (treeName.isEmpty()) break;
            treeMap.put(treeName, treeMap.getOrDefault(treeName, 0) + 1);
            total++;
        }

        // 트리맵 순회
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) { //entrySet()은 Map의 모든 키-값 쌍을 Set 형태로 반환하는 메서드
            String key = entry.getKey();
            double value = entry.getValue() * 100.0 / total;
            System.out.println(key + " " + String.format("%.4f", value));
        }
        
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}
