import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer  st= new StringTokenizer(br.readLine());
        int grundy = Integer.parseInt(st.nextToken());

        for(int i = 1; i<n;i++){
            grundy ^= Integer.parseInt(st.nextToken());
        }

        if(grundy == 0)
            System.out.println("cubelover");
        else
            System.out.println("koosaga");
    }
}
