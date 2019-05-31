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

public class JO_1840_ДЎБо1 {

	public static int R, C;
	public static int[][] map;
	public static boolean[][] isVisited;
	public static Queue<Coordinate> outside = new LinkedList<>();
	public static Queue<Coordinate> q = new LinkedList<>();
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int answer, lastSize;
	
	public static void main(String[] args) {
		input();
		while (true) {
			clearVisited();
			bfsOutside();
			if (q.isEmpty()) break;
			answer++;
			lastSize = q.size();
			bfsMelt();
		}
		output();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		isVisited = new boolean[R][C];
		
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
	public static void clearVisited() {
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				isVisited[i][j] = false;
			}
		}
	}
	public static void bfsOutside() {
		outside.add(new Coordinate(0, 0));
		isVisited[0][0] = true;
		
		while (!outside.isEmpty()) {
			int x = outside.peek().x;
			int y = outside.peek().y;
			outside.poll();
			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < R && 0 <= ny && ny < C) {
					if (isVisited[nx][ny]) continue;
					if (map[nx][ny] == 0) {
						outside.add(new Coordinate(nx, ny));
						isVisited[nx][ny] = true;
					}
					if (map[nx][ny] == 1) {
						q.add(new Coordinate(nx, ny));
						isVisited[nx][ny] = true;
					}
				}
			}
			
		}
	}
	public static void bfsMelt() {
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			map[x][y] = 0;
		}
	}
	public static void output() {
		System.out.println(answer);
		System.out.println(lastSize);
	}

}
