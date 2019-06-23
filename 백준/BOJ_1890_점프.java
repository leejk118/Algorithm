import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890_점프 {
	
	public static int N;
	public static int[][] map;
	public static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		input();
		dp[0][0] = 1;
		for (int x = 0; x < N; ++x) {
			for (int y = 0; y < N; ++y) {
				if (map[x][y] == 0) continue;
				int nx = x + map[x][y];
				int ny = y + map[x][y];
				if (nx < N) dp[nx][y] += dp[x][y];
				if (ny < N)	dp[x][ny] += dp[x][y];
			}
		}
		System.out.println(dp[N - 1][N - 1]);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
		}	
	}
}
