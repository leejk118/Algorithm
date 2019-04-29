/**************************************************************
    Problem: 1491
    User: leejk118
    Language: Java
    Result: Success
    Time:145 ms
    Memory:8956 kb
****************************************************************/
 
 
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int maxDistance = sc.nextInt();
        int numOfShop = sc.nextInt();
        int[] dist = new int[numOfShop + 1];
        int[] repairTime = new int[numOfShop + 2];
         
        for (int i = 0; i <= numOfShop; ++i) {
            dist[i] = sc.nextInt();
        }
        for (int i = 1; i <= numOfShop; ++i) {
            repairTime[i] = sc.nextInt();
        }
         
        int[] dp = new int[numOfShop + 2];
        dp[0] = 0;
        dp[1] = repairTime[1];
        repairTime[numOfShop + 1] = 0;
         
        int num;
        for (int i = 2; i <= numOfShop + 1; ++i) {
            int min = 999999;
            int index = i - 1;
            int distance = maxDistance;
            while (true) {
                if (index < 0) break;
                if (dist[index] <= distance) {
                    num = dp[index] + repairTime[i];
                    distance -= dist[index];
                    index--;
                    if (min > num)
                        min = num;
                }
                else
                    break;
            }
             
            dp[i] = min; 
        }
        System.out.println(dp[numOfShop + 1]);
        boolean[] isVisited = new boolean[numOfShop + 2];
        int index = numOfShop + 1;
        int count = 0;
        for (int i = numOfShop; i > 0; --i) {
            if (repairTime[index] == dp[index] - dp[i]) {
                isVisited[i] = true;
                index = i;
                count++;
            }
        }
        if (count != 0)
            System.out.println(count);
        for (int i = 0; i < numOfShop + 2; ++i) {
            if (isVisited[i])
                System.out.print(i + " ");
        }
         
    }
 
}
