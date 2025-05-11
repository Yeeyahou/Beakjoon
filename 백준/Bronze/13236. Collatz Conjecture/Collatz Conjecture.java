import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 입력 받기

        StringBuilder sb = new StringBuilder();

        while (n != 1) {
            sb.append(n).append(" ");  // 현재 숫자 추가
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        sb.append("1");  // 마지막 1 추가

        System.out.println(sb.toString());  // 결과 출력
    }
}
