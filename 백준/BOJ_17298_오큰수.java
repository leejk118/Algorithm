import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Coord{
	int index, num;
	Coord (int index, int num){
		this.index = index;
		this.num = num;
	}
}

public class BOJ_17298_오큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] answer = new int[N];
		int input;
		Stack<Coord> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			input = Integer.parseInt(st.nextToken());
			if (stack.isEmpty()) {
				stack.push(new Coord(i, input));
				continue;
			}
			while (!stack.isEmpty() && stack.peek().num < input) {
				answer[stack.peek().index] = input;
				stack.pop();
			}
			stack.push(new Coord(i, input));
		}
		while (!stack.isEmpty()) {
			answer[stack.peek().index] = -1;
			stack.pop();
		}
		for (int data : answer)
			System.out.print(data + " ");
	}

}
