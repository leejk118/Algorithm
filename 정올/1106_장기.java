/**************************************************************
    Problem: 1106
    User: leejk118
    Language: Java
    Result: Success
    Time:167 ms
    Memory:10652 kb
****************************************************************/
 
 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class Coordinate{
    int x, y;
    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
 
    static int N, M, R, C, S, K;
    static int[][] isVisited;
    static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    static int answer;
     
    public static void main(String[] args) {
        input();
        bfs();
        output();
    }
     
    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();
        S = sc.nextInt();
        K = sc.nextInt();
        isVisited = new int[N + 1][M + 1];
        sc.close();
    }
    public static void bfs() {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(R, C));
        isVisited[R][C] = 0;
         
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for (int i = 0; i < 8; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (1 <= nx && nx <= N && 1 <= ny && ny <= M) {
                    if (isVisited[nx][ny] != 0) continue;
                    q.add(new Coordinate(nx, ny));
                    isVisited[nx][ny] = isVisited[x][y] + 1;
                    if (nx == S && ny == K) {
                        answer = isVisited[nx][ny];
                        return ;
                    }
                }
            }
        }
    }
    public static void output() {
        System.out.println(answer);
    }
}
