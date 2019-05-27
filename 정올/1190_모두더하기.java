/**************************************************************
    Problem: 1190
    User: leejk118
    Language: Java
    Result: Success
    Time:282 ms
    Memory:14660 kb
****************************************************************/
 
 
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class Main {
 
    public static int N;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static long answer;
     
    public static void main(String[] args) {
        input();
        add();
        output();
    }
     
    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; ++i) {
            pq.add(sc.nextInt());
        }
        sc.close();
    }
    public static void add() {
        int x, y;
        for (int i = 0; i < N-1; ++i) {
            x = pq.peek();
            pq.poll();
            y = pq.peek();
            pq.poll();
            pq.add(x + y);
            answer += (x + y);
        }
    }
    public static void output() {
        System.out.println(answer);
    }
 
}
