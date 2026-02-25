import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        double[] arr = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }
        
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        
        Arrays.sort(arr);
        
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double average = sum / n;
        
        System.out.println(Math.max(arr[n - 2], average));
    }
}
