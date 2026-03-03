import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String k = st.nextToken();
        String s = st.nextToken();
        Pos king = new Pos(k);
        Pos stone = new Pos(s);

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String move = br.readLine();
            int mx = 0;
            int my = 0; //이동할 칸의 값
            // R : 한 칸 오른쪽으로
            if(move.equals("R")){
                mx = 1;
            }
            // L : 한 칸 왼쪽으로
            if(move.equals("L")){
                mx = -1;
            }
            // B : 한 칸 아래로
            if(move.equals("B")){
                my = -1;
            }
            // T : 한 칸 위로
            if(move.equals("T")){
                my = 1;
            }
            // RT : 오른쪽 위 대각선으로
            if(move.equals("RT")){
                mx = 1;
                my = 1;
            }
            // LT : 왼쪽 위 대각선으로
            if(move.equals("LT")){
                mx = -1;
                my = 1;
            }
            // RB : 오른쪽 아래 대각선으로
            if(move.equals("RB")){
                mx = 1;
                my = -1;
            }
            // LB : 왼쪽 아래 대각선으로
            if(move.equals("LB")){
                mx = -1;
                my = -1;
            }
            if (king.x + mx > 8 || king.x + mx < 1 || king.y + my > 8 || king.y + my < 1) continue;
            if (king.x + mx == stone.x && king.y + my == stone.y){
                if (stone.x + mx > 8 || stone.x + mx < 1 || stone.y + my > 8 || stone.y + my < 1) continue;
                stone.x += mx;
                stone.y += my;
            }
            king.x += mx;
            king.y += my;
        }
        String ks = String.valueOf((char)(king.x + 'A' - 1)) + king.y;
        String ss = String.valueOf((char)(stone.x + 'A' - 1)) + stone.y;

        System.out.println(ks);
        System.out.println(ss);
    }
}

class Pos{
    int x, y;

    public Pos(String pos){
        x = pos.charAt(0) - 'A' + 1;
        y = pos.charAt(1) - '0';
    }

}
