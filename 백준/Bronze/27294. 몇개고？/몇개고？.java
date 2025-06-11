import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 시간 (0~23)
        int S = sc.nextInt(); // 술 여부 (0 or 1)

        // 점심시간: 12~16 사이 (포함)
        boolean isLunchTime = (T >= 12 && T <= 16);
        boolean isDrinking = (S == 1);

        if (isLunchTime && !isDrinking) {
            System.out.println(320);
        } else {
            System.out.println(280);
        }
    }
}
