import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기 {

	public static void main(String[] args) throws IOException {
		int N, M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; ++j) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] dx = {-1, 0};
		int[] dy = {0, -1};
		int nx, ny, num;
		for (int x = 1; x <= N; ++x) {
			for (int y = 1; y <= M; ++y) {
				num = 0;
				for (int k = 0; k < 2; ++k) {
					nx = x + dx[k];
					ny = y + dy[k];
					if (1 <= nx & nx <= N & 1 <= ny & ny <= M) 
						num = max(num, map[nx][ny]); 
				}
				map[x][y] += num;
			}
		}
		System.out.println(map[N][M]);
	}
	public static int max(int a, int b) {
		return a > b ? a : b;
	}

}
