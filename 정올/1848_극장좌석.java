/**************************************************************
    Problem: 1848
    User: leejk118
    Language: Java
    Result: Success
    Time:130 ms
    Memory:9420 kb
****************************************************************/
 
 
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int input;
        boolean[] seat = new boolean[41];
        for (int i = 0; i < M; ++i) {
            input = sc.nextInt();
            seat[input] = true;
        }
         
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 40; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
         
        int answer = 1;
        int countSeat = 0;
        for (int i = 1; i <= N; ++i) {
            if (!seat[i]) {
                countSeat++;
            }
            else {
                if (countSeat != 0)
                    answer *= dp[countSeat];
                countSeat = 0;
            }
        }
        if (countSeat != 0)
            answer *= dp[countSeat];
         
        System.out.println(answer);
    }
 
}
