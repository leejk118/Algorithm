import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_7699_수지의수지맞는여행 {

	public static int R, C;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	public static int[][] map;
	public static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			boolean[] isVisited = new boolean[26];
			answer = 0;
			
			for (int i = 0; i < R; ++i) {
				String str = br.readLine();
				for (int j = 0; j < C; ++j)
					map[i][j] = str.charAt(j) - 'A';
			}
			isVisited[map[0][0]] = true;
			dfs(0, 0, 1, isVisited);
			System.out.println("#" + tc + " " + answer);
		}
	}
	public static void dfs(int x, int y, int count, boolean[] isVisited) {
		int nx, ny;
		for (int i = 0; i < 4; ++i) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (0 <= nx && nx < R && 0 <= ny && ny < C) {
				if (isVisited[map[nx][ny]]) continue;
				isVisited[map[nx][ny]] = true;
				dfs(nx, ny, count + 1, isVisited);
				isVisited[map[nx][ny]] = false;
			}
		}
		if (count > answer) answer = count;
	}

}
