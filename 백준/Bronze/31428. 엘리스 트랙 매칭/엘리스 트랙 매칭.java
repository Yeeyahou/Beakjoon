import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄: 친구 수 N
        int N = sc.nextInt();
        sc.nextLine();  // 개행 문자 처리

        // 두 번째 줄: 친구들이 지원하는 트랙 정보
        String[] friendsTracks = sc.nextLine().split(" ");

        // 세 번째 줄: 헬로빗이 지원하는 트랙
        String hellobitsTrack = sc.nextLine();

        // 같은 트랙을 지원하는 친구 수 세기
        int count = 0;
        for (String track : friendsTracks) {
            if (track.equals(hellobitsTrack)) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
