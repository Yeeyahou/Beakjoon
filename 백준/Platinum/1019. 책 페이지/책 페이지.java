import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long arr[] = new long[10];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        solve(n);

        StringBuilder sb = new StringBuilder();
         for(int i = 0; i < 10; i ++){
            sb.append(arr[i] + " ");
         }

         System.out.println(sb.toString());
    }

    static void solve(long n) {
        // n의 자릿수 구하기
        int digit = String.valueOf(n).length();
        long res = 0;
        long dNum = 1; // 1, 10, 100, 1000...등의 자리의 기준 수
        for (int i = 0; i < digit; i++) {
            // step 1
            for(int j = 0; j < 10; j ++){
                if(j == 0) 
                    arr[j] += (n / (dNum * 10) - 1) *dNum;
                else
                    arr[j] += (n / (dNum * 10)) *dNum;
            }
            // step 2
            long tmp = (n % (dNum * 10)) / dNum; // 현재 dNum이 해당하는 자리의 숫자
            for(int j = 0; j < tmp; j ++){
                arr[j] += dNum;
            }
            // step 3
            //if(((int)tmp)%10 !=0)
                arr[(int)tmp] += (n % dNum + 1);
            
            // 0은 맨 앞자리에 올 수 없음 (일의 자리 제외)
            // if( i != 0)
            //      arr[0] -= dNum/10 -1;
            
            dNum *= 10;
        }
        //arr[0]--;
    }
}
