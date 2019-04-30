/**************************************************************
    Problem: 2000
    User: leejk118
    Language: Java
    Result: Success
    Time:138 ms
    Memory:9268 kb
****************************************************************/
 
 
import java.util.Scanner;
 
public class Main {
    static int N;
    static int W;
    static int[] coin;
    static int answer;
     
    public static void main(String[] args) {
        input();
        dp();
        output();
    }
     
    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coin = new int[N];
        for (int i = 0; i < N; ++i) {
            coin[i] = sc.nextInt();
        }
        W = sc.nextInt();
        sc.close();
    }
    static void dp() {
        int[] dp = new int[W + 1];
        int min;
        initialize(dp);
         
        for (int i = 1; i <= W; ++i) {
            min = (dp[i] == 1) ? 1 : 99999;
            for (int j = 0; j < N; ++j) {
                int rest = i - coin[j];
                if (i - coin[j] >= 0 && dp[rest] != 0) {
                    min = (min > 1 + dp[rest]) ? 1 + dp[rest] : min;
                }
            }
             
            dp[i] = (min == 99999) ? 0 : min; 
        }
         
        answer = dp[W];
    }
    static void initialize(int[] dp) {
        for (int i = 0; i < N; ++i) {
            if (coin[i] > W)
                continue;
            dp[coin[i]] = 1;
        }
    }
    static void output() {
        if (answer == 0)
            System.out.println("impossible");
        else
            System.out.println(answer);
    }
}
