import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {

	static int N;
	static int[] ary;
	static int[] dp;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		input();
		lis();
		output();
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ary = new int [N];
		dp = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) 
			ary[i] = Integer.parseInt(st.nextToken());
	}
	public static void lis() {
		dp[0] = ary[0];
		int length = 1;
		for (int i = 1; i < N; ++i) {
			if (ary[i] > dp[length - 1]) {
				dp[length] = ary[i];
				length++;
			}
			else if (ary[i] < dp[0]) {
				dp[0] = ary[i];
			}
			else {
				int index = Arrays.binarySearch(dp, 0, length, ary[i]);
				if (index >= 0)
					dp[index] = ary[i];
				else 
					dp[-index-1] = ary[i];
			}
		}
		answer = length;
	}
	public static void output() {
		System.out.println(answer);
	}

}
