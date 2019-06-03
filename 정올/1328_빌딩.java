/**************************************************************
    Problem: 1328
    User: leejk118
    Language: Java
    Result: Success
    Time:1993 ms
    Memory:65536 kb
****************************************************************/
 
 
import java.util.Scanner;
import java.util.Stack;
 
class Building{
    int index, height;
    Building (int index, int height){
        this.index = index;
        this.height = height;
    }
}
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Building> st = new Stack<>();
        int N;
        int inputHeight;
         
        N = sc.nextInt();
        int[] answer = new int[N + 1];
         
        for (int i = 1; i <= N; ++i) {
            inputHeight = sc.nextInt();
            if (st.isEmpty() || st.peek().height >= inputHeight) {
                st.push(new Building (i, inputHeight));
                continue;
            }
            while (!st.isEmpty() && st.peek().height < inputHeight) {
                answer[st.peek().index] = i;
                st.pop();
            }
            st.push(new Building (i, inputHeight));
        }
        sc.close();
        for (int i = 1; i <= N; ++i) {
            System.out.println(answer[i]);
        }
    }
 
}
