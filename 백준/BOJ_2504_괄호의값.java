import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class BOJ_2504_°ýÈ£ÀÇ°ª {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		Stack<String> stack = new Stack<>();
		int num;

		for (int i = 0, length = str.length(); i < length; ++i) {
			num = 0;
			if (stack.isEmpty()) {
				stack.push("" + str.charAt(i));
				continue;
			}
			if (stack.peek().equals("(")) {
				if (str.charAt(i) == ')') {
					stack.pop();
					stack.push("2");
				}
				else {
					stack.push("" + str.charAt(i));
					continue;
				}
			}
			else if (stack.peek().equals("[")) {
				if (str.charAt(i) == ']') {
					stack.pop();
					stack.push("3");
				}
				else {
					stack.push("" + str.charAt(i));
					continue;
				}				
			}
			else {
				if (!stack.peek().equals("(") & !stack.peek().equals("[")
						& !stack.peek().equals(")") & !stack.peek().equals("]")) {
					num = Integer.parseInt(stack.peek());
					stack.pop();
					if (stack.isEmpty()) {
						stack.push("" + num);
						stack.push("" + str.charAt(i));
					}
					else {
						if (stack.peek().equals("(") & str.charAt(i) == ')') {
							stack.pop();
							stack.push("" + num * 2);
						}
						else if (stack.peek().equals("[") & str.charAt(i) == ']') {
							stack.pop();
							stack.push("" + num * 3);
						}
						else {
							stack.push("" + num);
							stack.push("" + str.charAt(i));
						}
					}
				}
				
			}
			if (!stack.peek().equals("(") & !stack.peek().equals("[")
					& !stack.peek().equals(")") & !stack.peek().equals("]")) {
				num = Integer.parseInt(stack.peek());
				stack.pop();
				if (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("[")) {
					num += Integer.parseInt(stack.peek());
					stack.pop();
					stack.push("" + num);
				}
				else
					stack.push("" + num);
			}
		}
		
		if (stack.peek().equals("(") | stack.peek().equals(")") | stack.peek().equals("[") |
				stack.peek().equals("]")) {
			System.out.println("0");
		}
		else {
			int answer = Integer.parseInt(stack.peek());
			stack.pop();
			if (!stack.isEmpty()) 
				System.out.println("0");
			else 
				System.out.println(answer);
		}
	}

}
