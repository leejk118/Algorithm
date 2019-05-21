/**************************************************************
    Problem: 1681
    User: leejk118
    Language: Java
    Result: Success
    Time:1192 ms
    Memory:11092 kb
****************************************************************/
 
 
import java.util.Scanner;
 
public class Main {
 
    static int N;
    static int[][] matrix;
    static int answer = Integer.MAX_VALUE;
    static boolean[] isVisited;
     
    public static void main(String[] args) {
        input();
        backtrack(0, 0, 1);
        output();
    }
     
    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new int[N + 1][N + 1];
        isVisited = new boolean [N + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }
    public static void backtrack(int count, int cost, int currentPos) {
        if (count == N - 1) {
            if (matrix[currentPos][1] == 0) return ;
            cost += matrix[currentPos][1];
            if (cost < answer)
                answer = cost;
            return ;
        }
        for (int i = 2; i <= N; ++i) {
            if (isVisited[i] || currentPos == i || matrix[currentPos][i] == 0) continue;
            isVisited[i] = true;
            backtrack(count + 1, cost + matrix[currentPos][i], i);
            isVisited[i] = false;
        }
    }
    public static void output() {
        System.out.println(answer);
    }
 
}
