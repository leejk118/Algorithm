/**************************************************************
    Problem: 1077
    User: leejk118
    Language: Java
    Result: Success
    Time:271 ms
    Memory:17596 kb
****************************************************************/
 
 
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N, W;
        int wi, pi;
        N = sc.nextInt();
        W = sc.nextInt();
 
        int[][] jewel = new int[N][2];
        int[] dp = new int[W + 1];
        int min = 999999999;
 
        for (int i = 0; i < N; ++i) {
            wi = sc.nextInt();
            pi = sc.nextInt();
            jewel[i][0] = wi;
            jewel[i][1] = pi;
            if (wi < min)
                min = wi;
        }
 
        for (int i = 0; i < min; ++i) {
            dp[i] = 0;
        }
        int max;
        int sum;
        for (int i = min; i <= W; ++i) {
            max = 0;
            for (int j = 0; j < N; ++j) {
                if (i - jewel[j][0] >= 0) {
                    sum = (jewel[j][1] + dp[i - jewel[j][0]]);
                    if (sum > max)
                        max = sum;
                }
            }
            if (max != 0)
                dp[i] = max;
        }
        sc.close();
        System.out.println(dp[W]);
    }
 
}
