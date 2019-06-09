import java.util.Scanner;
import java.util.Stack;

class Top{
	int index;
	int height;
	Top (int index, int height){
		this.index = index;
		this.height = height;
	}
}

public class JO_1809_탑 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int input;
		int[] answer = new int [N];
		Stack<Top> st = new Stack<>();
		
		for (int i = 0; i < N; ++i) {
			input = sc.nextInt();
		
			while (!st.isEmpty() && st.peek().height < input) 
				st.pop();
			if (st.isEmpty()) 
				st.push(new Top(i, input));
			else {
				answer[i] = st.peek().index + 1;
				st.push(new Top(i, input));
			}
		}
		for (int data : answer)
			System.out.print(data + " ");
		sc.close();
	}

}
