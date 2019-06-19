import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_9461_파도반수열 {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N;
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;
		for (int i = 7; i <= 100; ++i) 
			dp[i] = dp[i - 1] + dp[i - 5];

		for (int i = 0; i < T; ++i) {
			N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}

}
