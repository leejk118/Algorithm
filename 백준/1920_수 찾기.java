import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] A, B;
	
	public static void main(String[] args) {
		input();
		Arrays.sort(A);
		for (int i = 0; i < M; ++i) {
			if (binarySearch(0, N - 1, B[i]))
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; ++i) 
			A[i] = sc.nextInt();
		
		M = sc.nextInt();
		B = new int[M];
		for (int i = 0; i < M; ++i) 
			B[i] = sc.nextInt();
		sc.close();
	}
	static boolean binarySearch(int start, int end, int target) {
		if (start > end)
			return false;
		
		int mid = (start + end) / 2;
		if (A[mid] == target) 
			return true;
		if (A[mid] < target) 
			return binarySearch(mid + 1, end, target);
		else
			return binarySearch(start, mid - 1, target);
	}

}
