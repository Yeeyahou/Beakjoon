import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int res = 0;

        boolean[] sieve = new boolean[N+1];
        ArrayList<Integer> prime = new ArrayList<>();

        if(N==1){
            System.out.println(res);
            return;
        }

        for (int i = 2; i * i <= N; i++) {
            if (sieve[i] == false) {
                for (int j = i * i; j <= N; j += i) {
                    sieve[j] = true;
                }
            }
        }

        for (int i = 2; i <= N; i++){
            if (sieve[i] == false) {
                prime.add(i);
            }
        }

        int i = 0;
        int j = 0;
        int sum = 0;
        while (sum + prime.get(i) <= N) {
            sum += prime.get(i);
            i++;
            if(i >= prime.size()){
                break;
            }
        }
        if(sum == N) res++;

        if(i >= prime.size()){
            System.out.println(res);
            return;
        }

        while(prime.get(i) <= N){
            sum += prime.get(i);
            while(sum > N){
                sum -= prime.get(j);
                j++;
            }
            if(sum == N) res ++;
            i++;
            if(i >= prime.size()){
                break;
            }
        }

        System.out.println(res);
    }
}