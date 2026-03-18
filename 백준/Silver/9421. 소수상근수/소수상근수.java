import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static boolean prime[]; // true면 소수
    static boolean visited[]; // 방문 배열
    static boolean yes[]; // true면 상근수 확정
    static boolean no[]; // true면 상근수
    List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        prime = new boolean[n + 1];
        visited = new boolean[Math.max(n + 1, 200)];
        yes = new boolean[Math.max(n + 1, 200)];
        no = new boolean[Math.max(n + 1, 200)];
        Arrays.fill(prime, true);
        yes[1] = true;
        eratos(n);

        for (int i = 2; i < n + 1; i++) {
            if (prime[i])
                if (sangen(i))
                    System.out.println(i);
        }
    }

    static void eratos(int n) {
        prime[1] = false;

        for (int i = 2; i * i <= n + 1; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n + 1; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    static boolean sangen(int num) {
        String sNum = String.valueOf(num);
        int nextNum = 0;

        visited[num] = true;
        for (int i = 0; i < sNum.length(); i++) {
            int n = sNum.charAt(i) - '0';
            nextNum += n * n;
        }
        if (visited[nextNum]) {
            if (yes[nextNum]){
                yes[num] = true;
                return true;
            }
            no[num] = true;
            return  false;
        }

        boolean tmp = sangen(nextNum);
        if (tmp)
            yes[num] = true;
        else
            no[num] = true;

        return tmp;
    }
}
