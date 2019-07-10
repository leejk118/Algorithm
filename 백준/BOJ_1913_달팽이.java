import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913_´ÞÆØÀÌ {

	static int N;
	static int target;
	static int[][] matrix;
	static int[] answer = new int[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		target = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		
		int count = 0;
		for (int i = N; i > 0; i -= 2) {
			setMatrix(i, count++);
		}
		matrix[N / 2][N / 2] = 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		if (target == 1) {
			int center = N / 2 + 1;
			System.out.println(center + " " + center);
		}
		else 
			System.out.println((answer[0] + 1) + " " + (answer[1] + 1));
	}
	public static void setMatrix(int index, int count) {
		int num = index * index;
		index--;
		for (int i = 0; i < index; ++i) {
			matrix[count + i][count] = num--;
			if (matrix[count + i][count] == target) setAnswer(count + i, count);
		}	
		for (int i = 0; i < index; ++i) {
			matrix[N - count - 1][count + i] = num--;
			if (matrix[N - count - 1][count + i] == target) setAnswer(N - count - 1, count + i);
		}	
		for (int i = 0; i < index; ++i) {
			matrix[N - count - 1 - i][N - count - 1] = num--;
			if (matrix[N - count - 1 - i][N - count - 1] == target) setAnswer(N - count - 1 - i, N - count - 1);
		}
		for (int i = 0; i < index; ++i) {
			matrix[count][N - count - 1 - i] = num--;
			if (matrix[count][N - count - 1 -i] == target) setAnswer(count, N - count - 1 -i);
		}
	}
	public static void setAnswer(int x, int y) {
		answer[0] = x;
		answer[1] = y;
	}

}
