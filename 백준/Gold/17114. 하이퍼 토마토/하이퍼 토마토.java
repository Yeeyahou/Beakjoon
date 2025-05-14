import java.io.*;
import java.util.*;

public class Main {
    static class Tomato {
        int m, n, o, p, q, r, s, t, u, v, w;

        public Tomato(int w, int v, int u, int t, int s, int r, int q, int p, int o, int n, int m) {
            // m, n, o, p, q, r, s, t, u, v, w
            this.m = m;
            this.n = n;
            this.o = o;
            this.p = p;
            this.q = q;
            this.r = r;
            this.s = s;
            this.t = t;
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Tomato> queue = new LinkedList<>();
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int o = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][][][][][][][][][][] arr = new int[w][v][u][t][s][r][q][p][o][n][m];
        int fresh = 0; //안익은 토마토 수
        for (int w1 = 0; w1 < w; w1++) {
            for (int v1 = 0; v1 < v; v1++) {
                for (int u1 = 0; u1 < u; u1++) {
                    for (int t1 = 0; t1 < t; t1++) {
                        for (int s1 = 0; s1 < s; s1++) {
                            for (int r1 = 0; r1 < r; r1++) {
                                for (int q1 = 0; q1 < q; q1++) {
                                    for (int p1 = 0; p1 < p; p1++) {
                                        for (int o1 = 0; o1 < o; o1++) {
                                            for (int n1 = 0; n1 < n; n1++) {
                                                st = new StringTokenizer(br.readLine());
                                                for (int m1 = 0; m1 < m; m1++) {
                                                    int num = Integer.parseInt(st.nextToken());
                                                    if(num == 1){
                                                        Tomato tomato = new Tomato(w1, v1, u1, t1, s1, r1, q1, p1, o1, n1, m1);
                                                        queue.add(tomato);
                                                    }
                                                    else if(num == 0){
                                                        fresh++;
                                                    } 
                                                    arr[w1][v1][u1][t1][s1][r1][q1][p1][o1][n1][m1] = num;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int day = 1;
        //탐색 좌표 배열
        int[] m2 = { 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] n2 = { 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] o2 = { 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] p2 = { 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] q2 = { 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] r2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] s2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] t2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0};
        int[] u2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0};
        int[] v2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0};
        int[] w2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Tomato nowTomato = queue.poll();

            for (int i = 0; i < 22; i++) {
                int mm = nowTomato.m + m2[i];
                int nn = nowTomato.n + n2[i];
                int oo = nowTomato.o + o2[i];
                int pp = nowTomato.p + p2[i];
                int qq = nowTomato.q + q2[i];
                int rr = nowTomato.r + r2[i];
                int ss = nowTomato.s + s2[i];
                int tt = nowTomato.t + t2[i];
                int uu = nowTomato.u + u2[i];
                int vv = nowTomato.v + v2[i];
                int ww = nowTomato.w + w2[i];

                if( mm>= 0 && mm <= m-1 &&
                    nn>= 0 && nn <= n-1 &&
                    oo>= 0 && oo <= o-1 &&
                    pp>= 0 && pp <= p-1 &&
                    qq>= 0 && qq <= q-1 &&
                    rr>= 0 && rr <= r-1 &&
                    ss>= 0 && ss <= s-1 &&
                    tt>= 0 && tt <= t-1 &&
                    uu>= 0 && uu <= u-1 &&
                    vv>= 0 && vv <= v-1 &&
                    ww>= 0 && ww <= w-1 &&
                    arr[ww][vv][uu][tt][ss][rr][qq][pp][oo][nn][mm] == 0){
                        queue.add(new Tomato(ww, vv, uu, tt, ss, rr, qq, pp, oo, nn, mm));
                        arr[ww][vv][uu][tt][ss][rr][qq][pp][oo][nn][mm] = 
                        arr[nowTomato.w][nowTomato.v][nowTomato.u][nowTomato.t][nowTomato.s][nowTomato.r][nowTomato.q][nowTomato.p][nowTomato.o][nowTomato.n][nowTomato.m] + 1;
                        day = Math.max(day, arr[ww][vv][uu][tt][ss][rr][qq][pp][oo][nn][mm]);
                        fresh--;
                }
            }
        }

        if(fresh != 0) System.out.println(-1);
        else System.out.println(day - 1);
    }
}