import java.io.*;
import java.util.*;

public class Main {
    static class Applicant{
        int document;
        int interview;

        public Applicant(int a, int b){
            document = a;
            interview = b;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a-1] = b;                
            }

            int res = 0;
            int minval = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (minval >= arr[j]){
                    minval = arr[j];
                    res ++;
                }
            }
            System.out.println(res);
        }
    }
}