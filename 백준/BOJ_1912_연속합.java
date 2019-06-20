import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ary = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i)
			ary[i] = Integer.parseInt(st.nextToken());
		
		int max = ary[1];
		dp[1] = ary[1];
		for (int i = 2; i <= N; ++i) {
			dp[i] = Math.max(ary[i], dp[i - 1] + ary[i]);
			max = Math.max(dp[i], max);
		}
			
		System.out.println(max);
	}

}
