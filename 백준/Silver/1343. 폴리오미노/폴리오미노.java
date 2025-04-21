import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String in = br.readLine();
        Boolean isX = false;
        Boolean startX = false;
        int cnt = 0;
        int[] arr = new int[50];
        int p = 0;
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (i == 0 && c == 'X') {
                startX = true;
                isX = true;
                cnt++;
                continue;
            } else if (i == 0 && c == '.') {
                startX = false;
                isX = false;
                cnt++;
                continue;
            }
            if (c == 'X') {
                if (isX) {
                    cnt++;
                } else {
                    arr[p++] = cnt;
                    cnt = 1;
                    isX = true;
                }
            } else if (c == '.') {
                if (isX) {
                    arr[p++] = cnt;
                    cnt = 1;
                    isX = false;
                } else {
                    cnt++;
                }
            }
        }
        arr[p++] = cnt;

        String res = "";
        int n = 1;
        if (startX)
            n = 0;
        for (int i = 0; i < p; i++) {
            if(i%2==n){
                if(arr[i]%2 != 0){
                    System.out.println(-1);
                    return;
                }
                String a ="";
                int j = arr[i]/4;
                for(int k = 0; k < j; k ++){
                    a +="AAAA";
                }
                if(arr[i]%4 == 2)
                    a+= "BB";

                res += a;
            }
            else{
                for(int k = 0; k < arr[i]; k ++){
                    res += ".";
                }
            }
        }

        System.out.println(res);
    }
}