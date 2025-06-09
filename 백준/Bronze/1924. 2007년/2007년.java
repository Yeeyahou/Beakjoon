import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        // 각 월의 일수 (윤년 아님, 2007년은 평년)
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // 1월 1일부터 입력된 날짜까지의 총 일 수 계산
        int totalDays = 0;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        totalDays += day;

        // 요일 계산 (2007년 1월 1일은 월요일)
        String[] week = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
        System.out.println(week[(totalDays - 1) % 7]);
    }
}
