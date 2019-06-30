import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		char ch;
		while(true) {
			input = br.readLine();
			if (input.equals(".")) break;
			Stack<Character> st = new Stack<>();
			for (int i = 0, length = input.length(); i < length; ++i) {
				ch = input.charAt(i);
				if (ch == '(' || ch == ')' ||
						ch == '[' || ch == ']') {
					if (!st.isEmpty() && ch == ')' && st.peek() == '(') st.pop();
					else if (!st.isEmpty() && ch == ']' && st.peek() == '[') st.pop(); 
					else st.push(input.charAt(i));
				}
			}
			if (st.isEmpty()) System.out.println("yes");
			else System.out.println("no");
		}
	}

}
