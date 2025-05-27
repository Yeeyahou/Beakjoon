import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = sToi(st.nextToken());
        int m = sToi(st.nextToken());
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = sToi(st.nextToken());
            int b = sToi(st.nextToken());
            int c = sToi(st.nextToken());

            if(a == 0){
                connectNode(b, c);
                continue;
            }
            if(a == 1){
                if(isUnion(b, c))
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }

    static boolean isUnion(int a, int b){
        int fa = find(a);
        int fb = find(b);

        return(fa == fb);
    }

    static void connectNode(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if(fa != fb){
            parent[fa] = fb;
        }
    }

    static int find(int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
    
}
