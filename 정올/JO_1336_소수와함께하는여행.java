import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JO_1336_소수와함께하는여행 {

	public static StringBuffer start, end;
	public static int[] isVisited = new int[10000];
	
	public static void main(String[] args) {
		input();
		bfs();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		start = new StringBuffer(sc.next());
		end = new StringBuffer(sc.next());
		sc.close();
	}
	public static void bfs() {
		Queue<StringBuffer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			StringBuffer s = q.peek();
			q.poll();
			for (int i = 0; i < 4; ++i) {
				int num = start.charAt(i) - '0';
				for (int j = 0; j <= 9; ++j) {
					if (i == 0 && j == 0) continue;
					if (i == 3 && j % 2 == 0) continue;
					if (j == num) continue;
					
					StringBuffer temp = new StringBuffer(s);
					int x = toNumber(temp);
					temp.setCharAt(i, (char) (j + '0'));
					int nx = toNumber(temp);
					
					if (temp.toString().equals(end.toString())) {
						System.out.println(isVisited[x] + 1);
						return;
					}
					if (isPrimeNumber(nx)) {
						q.add(temp);
						isVisited[nx] = isVisited[x] + 1;
					}
				}
			}
		}
	}
	public static int toNumber(StringBuffer s) {
		int num = 0;
		for (int i = 0; i < 4; ++i) 
			num += (s.charAt(i) - '0') * Math.pow(10, 3-i);
		return num;
	}
	public static boolean isPrimeNumber(int nx) {
		if (isVisited[nx] > 0) return false;
		int sqrt = (int) Math.sqrt(nx);
		for (int i = 2; i <= sqrt; ++i) {
			if (nx % i == 0)
				return false;
		}
		return true;
	}

}
