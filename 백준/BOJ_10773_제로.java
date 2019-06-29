import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		int input, answer = 0;
		for (int i = 0; i < K; ++i) {
			input = Integer.parseInt(br.readLine());
			if (input == 0) st.pop();
			else st.push(input);
		}
		while (!st.isEmpty()) {
			answer += st.peek();
			st.pop();
		}
		System.out.println(answer);
	}

}
