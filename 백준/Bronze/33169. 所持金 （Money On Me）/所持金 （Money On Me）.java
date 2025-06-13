import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A = scanner.nextInt();  // 1,000엔 지폐 수
        int B = scanner.nextInt();  // 10,000엔 지폐 수
        
        int total = A * 1000 + B * 10000;
        
        System.out.println(total);
    }
}
