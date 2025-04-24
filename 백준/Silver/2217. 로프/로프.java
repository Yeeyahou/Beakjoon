import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int res = 0;

        for(int i = 0; i < N ; i++){
            int tmp = (N-i) * arr[i];

            if(tmp > res) res = tmp;
        }

        System.out.println(res);
    }
}
