import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result = a*b*c;
        int arr[] = new int[10];

        String result2 = String.valueOf(result);
        //123456789
        for(int i=0;i<result2.length();i++) {
            int n = result2.charAt(i) - '0';
            arr[n]++;
        }

        for(int i=0; i<10;i++){
            System.out.println(arr[i]);
        }
    }
}