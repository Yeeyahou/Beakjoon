import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 문자열 길이
        String S = sc.next(); // 문자열 입력

        int count = 0;

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o') {
                count++;
            }
        }

        System.out.println(count);
    }
}
