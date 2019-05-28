import java.util.ArrayList;
import java.util.Scanner;

public class JO_1824_½ºµµÄí {

	static final int SUDOKU_NUM = 9;
	static int[][] sudoku = new int[SUDOKU_NUM + 1][SUDOKU_NUM + 1];
	static ArrayList<Coordinate> al = new ArrayList<>();
	static int alSize, x, y;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		backtrack(0);
		//output();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= SUDOKU_NUM; ++i) {
			for (int j = 1; j <= SUDOKU_NUM; ++j) {
				sudoku[i][j] = sc.nextInt();
				if (sudoku[i][j] == 0) al.add(new Coordinate(i, j));
			}
		}
		alSize = al.size();
		sc.close();
	}
	public static void backtrack(int count) {
		if (count == alSize) {
			output();
			System.exit(0);
		}
		for (int i = count; i < alSize; ++i) {
			x = al.get(i).x;
			y = al.get(i).y;
			for (int j = 1; j <= SUDOKU_NUM; ++j) {
				sudoku[x][y] = j; 
				if (isPromising(x, y)) {
					backtrack(count+1);
				}
			}
		}
	}
	public static boolean isPromising(int x, int y) {
		for (int i = 1; i <= SUDOKU_NUM; ++i) {
			if (sudoku[x][y] == sudoku[x][i] || sudoku[x][y] == sudoku[i][y])
				return false;
		}
		
		return true;
		
	}
	public static void output() {
		for (int i = 1; i <= SUDOKU_NUM; ++i) {
			for (int j = 1; j <= SUDOKU_NUM; ++j) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
	}

}
