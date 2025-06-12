import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // H, I, A, R, C 입력 받기
        int H = sc.nextInt();
        int I = sc.nextInt();
        int A = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();

        // 첫 번째 항: H * I
        int firstTerm = H * I;

        // 두 번째 항: A * R * C
        int secondTerm = A * R * C;

        // 결과 출력: 첫 항 - 두 번째 항
        System.out.println(firstTerm - secondTerm);
    }
}
