import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = sToi(br.readLine());
        int res = 0;

        int[] heights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            int nowHeight = heights[i];
            int buildingNum = 0;
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                if (Math.abs(j - i) == 1) {
                    buildingNum++;
                    continue;
                }

                int start, end;
                if (j > i) {
                    start = i;
                    end = j;
                } else {
                    start = j;
                    end = i;
                }
                double gradient = (double)(heights[j] - heights[i]) / (j - i); // 기울기
                boolean flag = true;
                for (int k = start + 1; k < end; k++) {
                    if (heights[k] >= heights[start] + gradient * (k - start)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    buildingNum++;
            }
            maxVal = Math.max(maxVal, buildingNum);
        }

        System.out.println(maxVal);
    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }
}
