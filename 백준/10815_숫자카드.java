import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static int[] ary;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ary = new int[N];
		for (int i = 0; i < N; ++i) {
			ary[i] = sc.nextInt();
		}
		Arrays.sort(ary);
		int M = sc.nextInt();
		int target;
		for (int i = 0; i < M; ++i) {
			target = sc.nextInt();
			if (binarySearch(0, N - 1, target))
				System.out.print("1");
			else
				System.out.print("0");
			if (i == M - 1)
				break;
			System.out.print(" ");
		}
		sc.close();
	}
	
	static boolean binarySearch(int start, int end, int target) {
		if (start > end)
			return false;
		
		int mid = (start + end) / 2;
		if (ary[mid] == target)
			return true;
		if (ary[mid] < target) {
			return binarySearch(mid + 1, end , target);
		}
		else {
			return binarySearch(start, mid - 1, target);
		}
	}

}
