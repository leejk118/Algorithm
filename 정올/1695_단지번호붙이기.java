/**************************************************************
    Problem: 1695
    User: leejk118
    Language: Java
    Result: Success
    Time:162 ms
    Memory:9632 kb
****************************************************************/
 
 
import java.util.ArrayList;
import java.util.Collections;
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
 
public class Main  {
 
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> answer = new ArrayList<>();
     
    public static void main(String[] args) {
        input();
        bfsAll();
        output();
    }
     
    public static void input() {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        isVisited = new boolean[N][N];
         
        sc.nextLine();
        String str;
        for (int i = 0; i < N; ++i) {
            str = sc.nextLine();
            for (int j = 0; j < N; ++j) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        sc.close();
    }
    public static void bfsAll() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (isVisited[i][j] || map[i][j] == 0) continue;
                isVisited[i][j] = true;
                bfs(new Coordinate(i, j));
            }
        }
    }
    public static void bfs(Coordinate coordinate) {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(coordinate);
        int count = 1;
         
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (isVisited[nx][ny] || map[nx][ny] == 0) continue;
                    isVisited[nx][ny] = true;
                    count++;
                    q.add(new Coordinate(nx, ny));
                }
            }
        }
        answer.add(count);
    }
    public static void output() {
        Collections.sort(answer);
        int size = answer.size();
        System.out.println(size);
        for(int i = 0; i < size; ++i) {
            System.out.println(answer.get(i));
        }
    }
     
}
