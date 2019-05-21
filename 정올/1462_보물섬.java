/**************************************************************
    Problem: 1462
    User: leejk118
    Language: Java
    Result: Success
    Time:520 ms
    Memory:14904 kb
****************************************************************/
 
 
import java.util.ArrayList;
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
 
    static int R, C;
    static char[][] matrix;
    static boolean[][] isVisited;
    static int[][] subMatrix;
    static ArrayList<Coordinate> al = new ArrayList<>();
    static Queue<Coordinate> q = new LinkedList<>();
     
    static int x, y, nx, ny;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
     
    static int answer = Integer.MIN_VALUE;
     
    public static void main(String[] args) {
        input();
        bfsAll();
        output();
    }
     
    public static void input() {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        matrix = new char[R][C];
        isVisited = new boolean[R][C];
        subMatrix = new int[R][C];
        sc.nextLine();
        String str;
        for (int i = 0; i < R; ++i) {
            str = sc.nextLine();
            for (int j = 0; j < C; ++j) {
                matrix[i][j] = str.charAt(j);
                if (matrix[i][j] == 'L')
                    al.add(new Coordinate(i, j));
            }
        }
        sc.close();
    }
    public static void bfsAll() {
        for (int i = 0, size = al.size(); i < size; ++i) {
            bfs(al.get(i));
        }
    }
    public static void bfs(Coordinate start) {
        clearSubMatrix();
        clearIsVisited();
 
        q.add(start);
        isVisited[start.x][start.y] = true;
         
        while (!q.isEmpty()) {
            x = q.peek().x;
            y = q.peek().y;
 
            q.poll();
            for (int i = 0; i < 4; ++i) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    if (isVisited[nx][ny] || matrix[nx][ny] != 'L') continue;
                    subMatrix[nx][ny] = subMatrix[x][y] + 1; 
                    isVisited[nx][ny] = true;
                    q.add(new Coordinate(nx, ny));
                    if (subMatrix[nx][ny] > answer)
                        answer = subMatrix[nx][ny];
                }
            }
        }
    }
    public static void clearSubMatrix() {
        for (int i = 0; i < R; ++i) {
            for (int j = 0;j  < C; ++j)
                subMatrix[i][j] = 0;
        }
    }
    public static void clearIsVisited() {
        for (int i = 0; i < R; ++i) {
            for (int j = 0;j  < C; ++j)
                isVisited[i][j] = false;
        }
    }
    public static void output() {
        System.out.println(answer);
    }
 
}
