import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Coordinate{
	int x, y;
	Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class JO_2613_토마토 {

	public static int N, M;
	public static int[][] map;
	public static boolean[][] isVisited;
	public static Queue<Coordinate> q = new LinkedList<>();
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int answer;
	
	public static void main(String[] args) {
		input();
		check();
		bfs();
		output();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		isVisited = new boolean [N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					q.add(new Coordinate(i, j));
					isVisited[i][j] = true;
				}
			}
		}
		sc.close();
	}
	public static void check() {
		boolean isExist = false;
		outer:
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) {
					isExist = true;
					break outer;
				}
			}
		}
		if (!isExist) {
			System.out.println("0");
			System.exit(0);
		}
	}
	public static void bfs() {
		int x, y, nx, ny;
		
		while(!q.isEmpty()) {
			x = q.peek().x;
			y = q.peek().y;
			q.poll();
			for (int i = 0; i < 4; ++i) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (isVisited[nx][ny] || map[nx][ny] != 0) continue;
					if (map[nx][ny] == 0) {
						q.add(new Coordinate(nx ,ny));
						isVisited[nx][ny] = true;
						map[nx][ny] = map[x][y] + 1;
						answer = map[nx][ny];
					}
				}
			}
			
		}
	}
	public static void output() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) {
					System.out.println("-1");
					System.exit(0);
				}
			}
		}
		System.out.println(answer - 1);
	}

}
