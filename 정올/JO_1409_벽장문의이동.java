import java.util.Scanner;

public class JO_1409_벽장문의이동 {

	public static int n;
	public static int[] target;
	public static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int first = sc.nextInt();
		int second = sc.nextInt();
		int num = sc.nextInt();
		target = new int [num];
		for (int i = 0; i < num; ++i) {
			target[i] = sc.nextInt();
		}
		dfs(0, 0, first, second);
		System.out.println(answer);
		sc.close();
	}
	
	public static void dfs(int count, int cost, int first, int second) {
		if (count == target.length) {
			if (answer > cost)
				answer = cost;
			return ;
		}
		if (target[count] == first || target[count] == second)
			dfs(count + 1, cost, first, second);
		else if (target[count] < first) 
			dfs(count + 1, cost + (first - target[count]), target[count], second);
		else if (second < target[count])
			dfs(count + 1, cost + (target[count] - second), first, target[count]);
		else {
			dfs(count + 1, cost + (target[count] - first), target[count], second);
			dfs(count + 1, cost + (second - target[count]), first, target[count]);
		}
	}
}
