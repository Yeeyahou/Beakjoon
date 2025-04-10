import java.util.Scanner;
 
public class Main {
	
	static int[] seq;
	static int[] dp;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		seq = new int[N];
		dp = new int[N];
		
		
		for(int i = 0; i < N; i++) {
			seq[i] = in.nextInt();
		}
		int res = -1;
		// 0 ~ N-1 까지 모든 부분수열 탐색 
		for(int i = 0; i < N; i++) {
			res = Math.max(LIS(i),res);
		}
		
		System.out.println(res);
	}
	
	
	static int LIS(int N) {
		
		// 만약 탐색하지 않던 위치의 경우 
		if(dp[N] == 0) {
			dp[N] = 1;	// 1로 초기화 
			
			// N-1 부터 0까지중 N보다 작은 값들을 찾으면서 재귀호출. 
			for(int i = N - 1; i >= 0; i--) {
				if(seq[i] < seq[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}
		return dp[N];
	}
}