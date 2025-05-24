import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int startYear = 2024;
        int startMonth = 8;
        int interval = 7;

        int totalMonths = (startYear * 12 + startMonth - 1) + (N - 1) * interval;

        int year = totalMonths / 12;
        int month = totalMonths % 12 + 1;

        System.out.println(year + " " + month);
    }
}
