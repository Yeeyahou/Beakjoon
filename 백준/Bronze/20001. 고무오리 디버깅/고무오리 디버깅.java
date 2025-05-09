import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int problems = 0;
        String input = sc.nextLine(); // "고무오리 디버깅 시작"

        while (true) {
            input = sc.nextLine();
            if (input.equals("고무오리 디버깅 끝")) {
                break;
            }

            if (input.equals("문제")) {
                problems++;
            } else if (input.equals("고무오리")) {
                if (problems == 0) {
                    problems += 2; // 벌칙
                } else {
                    problems--; // 문제 해결
                }
            }
        }

        if (problems == 0) {
            System.out.println("고무오리야 사랑해");
        } else {
            System.out.println("힝구");
        }
    }
}
