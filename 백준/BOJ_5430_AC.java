import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5430_AC {

	public static void main(String[] args) throws IOException {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			int[] num = new int[n];
			String ary = br.readLine();
			ary = ary.replace("[", "").replace("]", "");

			st = new StringTokenizer(ary, ",");
			int index = 0;
			int front = 0, end = n - 1;
			while(st.hasMoreTokens()) {
				num[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			
			boolean isForward = true;
			boolean isError = false;
			for (int i = 0, length = command.length(); i < length; ++i) {
				if (command.charAt(i) == 'R') 
					isForward = !isForward;
				else {
					if (front > end) {
						isError = true;
						break;
					}
					if (isForward) 
						front++;
					else 
						end--;
				}
			}
			if(isError) 
				System.out.println("error");
			else {
				if (isForward) {
					System.out.print("[");
					for (int i = front; i <= end; ++i) {
						if (i == end) {
							System.out.print(num[i]);
							break;
						}
						System.out.print(num[i] + ",");
					}
					System.out.println("]");
				}
				else {
					System.out.print("[");
					for (int i = end; i >= front; --i) {
						if (i == front) {
							System.out.print(num[i]);
							break;
						}
						System.out.print(num[i] + ",");
					}
					System.out.println("]");
				}
			}
			
		}
			
	}

}
