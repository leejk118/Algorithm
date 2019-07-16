import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11279_최대힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input, ret;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; ++i) {
			input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (pq.isEmpty()) ret = 0;
				else {
					ret = -pq.peek();
					pq.poll();
				}
				System.out.println(ret);
			}
			else pq.offer(-input);
		}
	}

}
