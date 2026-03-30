import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int zeroNum = 0; // 0의 갯수

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                zeroNum++;
            arr[i] = num;
        }

        Arrays.sort(arr);
        int j = n-1;
        int res = 0;
        while (true) {
            if(j == -1) break;
            int num1 = arr[j];
            j--;
            if(j == -1){
                if(num1 > 0) res += num1;
                break;
            }
            int num2 = arr[j];

            if(num1 >= 2 && num2 >= 2){
                res += num1 * num2;
                j--;
                continue;
            }

            if(num1 == 1 || num2 == 1){
                res += num1;
                if(num2 > 0)
                    res += num2;
                j--;
                continue;
            }
            if(num1 >1) res += num1;
            if(num2 >1) res += num2;
            if(num1 <=0 || num2 <= 0) break;
            j--;
        }

        j = 0;
        while (true) {
            int num1 = arr[j];
            j++;
            if(j == n){
                if(num1 < 0) res += num1;
                break;
            }
            int num2 = arr[j];
            
            if(num1 < 0 && num2 < 0){
                res += num1 * num2;
                j++;
                continue;
            }

            if (num1 >= 0) break;
            if (zeroNum == 0){
                res += num1;
            }
            
            break;
        }

        System.out.println(res);
    }
}

