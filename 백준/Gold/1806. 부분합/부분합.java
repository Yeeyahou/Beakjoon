    import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int res = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        int p1 = 0;
        int p2 = 0; //처음, 끝 가리키는 포인터
        int sum = 0;

        for(int i = 0; i < n; i ++){
            int num = Integer.parseInt(st.nextToken());
            if(num >= s){
                System.out.println(1);
                return;
            }
            sum += num;
            arr[i] = num;
            p2 = i;

            if(sum >= s){
                while (true) {
                    if(p1 == p2)break;
                    if(sum - arr[p1] < s) break;
                    sum -= arr[p1];
                    p1++;
                }
                res = Math.min(res, p2 - p1 + 1);
            }
        }

        if(res == Integer.MAX_VALUE){
            System.out.println(0);
            return;
        }
        System.out.println(res);
    }
}