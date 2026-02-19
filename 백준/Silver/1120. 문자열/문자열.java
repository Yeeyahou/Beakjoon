import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String t1 = st.nextToken();
        String t2 = st.nextToken();
        
        int res = t1.length();
        for(int i = 0; i < t2.length() - t1.length() + 1; i++){
            int tmpRes = t1.length();
            for(int j = 0; j < t1.length(); j++){
                if(t1.charAt(j) == t2.charAt(i + j))
                    tmpRes--;
            }
            res = Math.min(res,tmpRes);
        }

        System.out.println(res);
    }
}
