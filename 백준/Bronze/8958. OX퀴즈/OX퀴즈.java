import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int res = 0;
            int semiRes = 0;

            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'O'){
                    semiRes++;
                    res += semiRes;
                }
                else if(s.charAt(j) == 'X'){
                    semiRes = 0;
                }
            }
            System.out.println(res);
        }
    }
}
