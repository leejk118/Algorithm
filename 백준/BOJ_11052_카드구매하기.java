import java.util.Scanner;

public class BOJ_11052_카드구매하기 {

	public static void main(String[] args) {
		int N;
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int[] card = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; ++i) 
			card[i] = sc.nextInt();
	
		dp[0] = 0;
		dp[1] = card[1];
		for (int i = 2; i <= N; ++i) {
			int num = 0;
			for (int j = 1; j <= N; ++j) {
				if (i - j < 0) continue;
				 num = max(num, dp[i - j] + card[j]);
			}
			dp[i] = num;
		}
		System.out.println(dp[N]);
		
		sc.close();
	}
	
	public static int max(int a, int b) {
		return (a > b ? a : b);
	}

}
