/**************************************************************
    Problem: 1889
    User: leejk118
    Language: Java
    Result: Success
    Time:1324 ms
    Memory:10716 kb
****************************************************************/
 
 
import java.util.Scanner;
 
public class Main {
 
    static int N;
    static int answer;
    static int[] ary;
     
    public static void main(String[] args) {
        input();
        nQueen(0);
        output();
    }
     
    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ary = new int[N];
        sc.close();
    }
    public static void nQueen(int count) {
        if (count == N) {
            answer++;
            return ;
        }
        for (int i = 0; i < N; ++i) {
            ary[count] = i;
            if (isPromising(count)) {
                nQueen(count + 1);
            }
        }
    }
    public static boolean isPromising(int count) {
        boolean isPromising = true;
        int row, col;
        int x = count, y = ary[count];
         
        for (int i = 0; i < count; ++i) {
            row = i;
            col = ary[i];
            if (x == row || y == col || 
                    x - y == row - col || x + y == row + col) {
                isPromising = false;
                break;
            }
        }
        return isPromising;
    }
    public static void output() {
        System.out.println(answer);
    }
 
}
