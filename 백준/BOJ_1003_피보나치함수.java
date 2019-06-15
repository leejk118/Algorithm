import java.util.Scanner;

public class BOJ_1003_피보나치함수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, testcase;
		T = sc.nextInt();
		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int i = 2; i <= 40; ++i) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
		
		for (int tc = 1; tc <= T; ++tc) {
			testcase = sc.nextInt();
			System.out.println(dp[testcase][0] + " " + dp[testcase][1]);
		}
		sc.close();
	}

}
