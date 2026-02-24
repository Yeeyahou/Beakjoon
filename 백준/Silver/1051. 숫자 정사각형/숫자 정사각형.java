import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int side = Math.min(N, M) - 1; //시작 변의 길이
        
        char arr[][] = new char[N][M];
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine().toCharArray();
        }

        while (side >= 1) {
            for(int i = 0; i < N - side; i++){
                for(int j = 0; j < M - side; j++){
                    if(arr[i][j] == arr[i][j + side] &&
                        arr[i][j] == arr[i + side][j] &&
                        arr[i][j] == arr[i + side][j + side]
                    ){
                        System.out.println((side + 1) * (side + 1));
                        return;
                    }
                }
            }
            side--;
        }
        System.out.println(1);
    }
}
