import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord {
	int x, y;
	Coord(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ_3055_탈출  {

	public static int R, C;
	public static int[][] map;
	public static boolean[][] isVisited;
	public static Queue<Coord> qStart = new LinkedList<>();
	public static Queue<Coord> qWater = new LinkedList<>();
	public static boolean isArrived;
	public static boolean isDead;
	public static final int LAND = 0;
	public static final int WATER = -1;
	public static final int DESTINATION = -2;
	public static final int WALL = -3;
	public static final int START = 0;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	public static int answer;
	
	public static void main(String[] args) throws IOException {
		input();
		bfs();
		if (answer == 0) System.out.println("KAKTUS");
		else System.out.println(answer);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		isVisited = new boolean[R][C];
		for (int i = 0; i < R;  ++i) {
			String input = br.readLine();
			for (int j = 0; j < C; ++j) {
				if (input.charAt(j) == '.') map[i][j] = LAND;
				else if (input.charAt(j) == 'D') map[i][j] = DESTINATION;
				else if (input.charAt(j) == 'X') map[i][j] = WALL;
				else if (input.charAt(j) == '*') {
					map[i][j] = WATER;
					qWater.add(new Coord(i, j));
				}
				else {
					map[i][j] = START;
					qStart.add(new Coord(i, j));
				}
			}
		}
	}
	public static void bfs() {
		while (true) {
			if (isArrived || isDead) break;
			bfsWater();
			bfsMove();
		}
	}
	public static void bfsWater() {
		int qSize = qWater.size();
		for (int i = 0; i < qSize; ++i) {
			int x = qWater.peek().x;
			int y = qWater.peek().y;
			qWater.poll();
			for (int j = 0; j < 4; ++j) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (0 <= nx && nx < R && 0 <= ny && ny < C) {
					if (isVisited[nx][ny]) continue;
					if (map[nx][ny] >= LAND) {
						isVisited[nx][ny] = true;
						qWater.add(new Coord(nx, ny));
					}
				}
			}
		}
	}
	public static void bfsMove() {
		int qSize = qStart.size();
		if (qSize == 0) {
			isDead = true;
			return ;
		}
		for (int i = 0; i < qSize; ++i) {
			int x = qStart.peek().x;
			int y = qStart.peek().y;
			qStart.poll();
			for (int j = 0; j < 4; ++j) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (0 <= nx && nx < R && 0 <= ny && ny < C) {
					if (isVisited[nx][ny]) continue;
					if (map[nx][ny] == DESTINATION) {
						answer = map[x][y] + 1;
						isArrived = true;
						return ;
					}
					if (map[nx][ny] == LAND) {
						map[nx][ny] = map[x][y] + 1;
						isVisited[nx][ny] = true;
						qStart.add(new Coord(nx, ny));
					}
				}
			}
		}
	}

}
