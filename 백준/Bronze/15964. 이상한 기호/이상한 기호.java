import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        // 연산 수행: (A + B) * (A - B)
        int result = (A + B) * (A - B);

        // 결과 출력
        System.out.println(result);
    }
}
