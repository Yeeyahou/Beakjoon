import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Visiting team input
        int t1 = sc.nextInt(); // Touchdowns
        int f1 = sc.nextInt(); // Field goals
        int s1 = sc.nextInt(); // Safeties
        int p1 = sc.nextInt(); // Point after
        int c1 = sc.nextInt(); // Two-point conversion

        // Home team input
        int t2 = sc.nextInt();
        int f2 = sc.nextInt();
        int s2 = sc.nextInt();
        int p2 = sc.nextInt();
        int c2 = sc.nextInt();

        // Score calculation
        int score1 = t1 * 6 + f1 * 3 + s1 * 2 + p1 * 1 + c1 * 2;
        int score2 = t2 * 6 + f2 * 3 + s2 * 2 + p2 * 1 + c2 * 2;

        // Output result
        System.out.println(score1 + " " + score2);
    }
}
