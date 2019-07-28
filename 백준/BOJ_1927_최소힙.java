import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; ++i) {
			input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (pq.isEmpty()) System.out.println(0);
				else {
					System.out.println(pq.peek());
					pq.poll();
				}
			}
			else pq.offer(input);
		}
	}

}
