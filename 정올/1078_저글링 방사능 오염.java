/**************************************************************
    Problem: 1078
    User: leejk118
    Language: Java
    Result: Success
    Time:218 ms
    Memory:10588 kb
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
     
    static int[][] map;
    static int R, C;
    static int startX, startY;
    static int time = 3, restZergling;
    static boolean[][] isVisited;
     
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
     
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        input();
        bfs();
        output();
    }
     
    public static void input() {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        R = sc.nextInt();
        map = new int[R][C];
        isVisited = new boolean[R][C];
         
        String str;
        sc.nextLine();
        for(int i = 0; i < R; ++i) {
            str = sc.nextLine();
            for (int j = 0; j < C; ++j) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        startY = sc.nextInt() - 1;
        startX= sc.nextInt() - 1;
        sc.close();
    }
    public static void bfs() {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(startX, startY));
        isVisited[startX][startY] = true;
        map[startX][startY] = 3;
         
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    if (!isVisited[nx][ny] && map[nx][ny] == 1) {
                        map[nx][ny] = map[x][y] + 1;
                        time = map[nx][ny];
                        q.add(new Coordinate(nx, ny));
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void output() {
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (map[i][j] == 1)
                    restZergling++;
            }
        }
         
        System.out.println(time);
        System.out.println(restZergling);
    }
 
}
