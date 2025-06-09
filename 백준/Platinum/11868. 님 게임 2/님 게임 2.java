import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = sToi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int grundy = sToi(st.nextToken());

        for(int i = 1; i < n; i++){
            grundy ^= sToi(st.nextToken());
        }

        if(grundy == 0){
            System.out.println("cubelover");
        }
        else{
            System.out.println("koosaga");
        }
    }

    static int sToi(String str) {
        return Integer.parseInt(str);
    }
}
