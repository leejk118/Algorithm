import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4948_베르트랑공준 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] num = new boolean[250000];
		num[2] = true;
		for (int i = 3; i < 250000; ++i) {
			if (isPrimeNumber(i))
				num[i] = true;
		}
		while (true) {
			int tc = Integer.parseInt(br.readLine());
			if (tc == 0) break;
			int sum = 0;
			for (int i = tc + 1; i <= 2 * tc; ++i) 
				if (num[i]) sum++;
			System.out.println(sum);
		}
	}
	public static boolean isPrimeNumber(int n) {
		int k = (int) Math.sqrt(n);
		for (int i = 2; i <= k; ++i) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
