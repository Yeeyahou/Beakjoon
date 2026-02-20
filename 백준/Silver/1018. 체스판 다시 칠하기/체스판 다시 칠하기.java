import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char board[][] = new char[n][m];
        for(int i = 0; i < n; i++){
            board[i] = bf.readLine().toCharArray();
        }

        int res = 64;
        for(int i = 0; i <= n - 8; i++){
            for(int j = 0; j <= m - 8; j++){
                char color = board[i][j]; //첫번째 칸 색
                int tmp1 = 64;
                int tmp2 = 64;
                for(int k = 0; k < 8; k++){
                    for(int l = 0; l < 8; l++){
                        switch(k % 2){
                            case 0:
                                switch(l % 2){
                                    case 0:
                                        if(board[i+k][j+l] == color)
                                            tmp1--;
                                        if(board[i+k][j+l] != color)
                                            tmp2--;
                                        break;
                                    case 1:
                                        if(board[i+k][j+l] != color)
                                            tmp1--;
                                        if(board[i+k][j+l] == color)
                                            tmp2--;
                                        break;
                                }
                                break;
                            case 1:
                                switch(l % 2){
                                    case 0:
                                        if(board[i+k][j+l] != color)
                                            tmp1--;
                                        if(board[i+k][j+l] == color)
                                            tmp2--;
                                        break;
                                    case 1:
                                        if(board[i+k][j+l] == color)
                                            tmp1--;
                                        if(board[i+k][j+l] != color)
                                            tmp2--;
                                        break;
                                }
                                break;
                        }
                    }
                }
                res = Math.min(res, Math.min(tmp1, tmp2));
            }
        }
        System.out.println(res);
    }
}
