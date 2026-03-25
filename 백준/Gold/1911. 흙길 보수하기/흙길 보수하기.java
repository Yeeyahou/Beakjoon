import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Hole holes[] = new Hole[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            holes[i] = new Hole(s, e);
        }
        Arrays.sort(holes);

        int stp = 0; // 넣빤지를 놓기 시작하는 포인트
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (holes[i].start > stp)
                stp = holes[i].start;
            
            int width = holes[i].end - stp;
            int stickNum; // 지금 놓아야 할 넣빤지의 갯수
            if (width <= 0)
                continue;

            if (width % L == 0)
                stickNum = width / L;
            else
                stickNum = width / L + 1;

            res += stickNum;
            stp += stickNum * L;
        }

        System.out.println(res);
    }

    public static class Hole implements Comparable<Hole> {
        int start;
        int end;

        public Hole(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Main.Hole o) {
            return this.start - o.start;
        }

    }
}
