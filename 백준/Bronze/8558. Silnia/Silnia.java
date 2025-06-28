import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
            result %= 10; // 일의 자리만 유지
            if (result == 0) break; // 일의 자리가 0이면 끝까지 0
        }

        System.out.println(result);
    }
}
