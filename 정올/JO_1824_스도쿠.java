/**************************************************************
    Problem: 1824
    User: leejk118
    Language: Java
    Result: Success
    Time:221 ms
    Memory:12668 kb
****************************************************************/
 
 
import java.util.ArrayList;
import java.util.Scanner;
 
class Coordinate{
    int x, y;
    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
 
    static final int SUDOKU_NUM = 9;
    static int[][] sudoku = new int[SUDOKU_NUM + 1][SUDOKU_NUM + 1];
    static ArrayList<Coordinate> al = new ArrayList<>();
    static int alSize, startX, startY;
     
    public static void main(String[] args) {
        input();
        backtrack(0);
        output();
    }
     
    public static void input() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < SUDOKU_NUM; ++i) {
            for (int j = 0; j < SUDOKU_NUM; ++j) {
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
 
        int x = al.get(count).x;
        int y = al.get(count).y;
        for (int j = 1; j <= SUDOKU_NUM; ++j) {
            if (isPromising(j, x, y)) {
                sudoku[x][y] = j;
                backtrack(count + 1);
                sudoku[x][y] = 0;
            }
                 
        }
    }
    public static boolean isPromising(int num, int x, int y) {
        for (int i = 0; i < SUDOKU_NUM; ++i) {
            if (num == sudoku[x][i] || num == sudoku[i][y])
                return false;
        }
        startX = x / 3 * 3;
        startY = y / 3 * 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (sudoku[i + startX][j + startY] == num)
                    return false;
            }
        }
        return true;
    }
    public static void output() {
        for (int i = 0; i < SUDOKU_NUM; ++i) {
            for (int j = 0; j < SUDOKU_NUM; ++j) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
 
}
