package b2167;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int X, Y, N;
    static int[][] map;
    static int[][] s;
    
    public static void main(String[] args) throws Throwable {
        
        System.setIn(new FileInputStream("2167.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        map = new int[X+1][Y+1];
        s = new int[X+1][Y+1];
        
        for (int i = 1; i <= Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= X; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        //정사각형 합 다 구해놓음.
        for (int i = 1; i <= Y; i++) {
            int sum = 0;
            for (int j = 1; j <= X; j++) {
                sum = sum + map[j][i];
                s[j][i] = s[j][i-1] + sum;
            }
        }
        
        
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int ay = Integer.parseInt(st.nextToken());
            int ax = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());
            int bx = Integer.parseInt(st.nextToken());
            
            Point p = new Point(ax,ay,bx,by);
            
            int result = s[bx][by] - s[ax-1][by] - s[bx][ay-1] + s[ax-1][ay-1];

            System.out.println(result); 
        }
        
        
        
        
    }
}

class Point {
    int ax;
    int ay;
    int bx;
    int by;
    public Point(int ax, int ay, int bx, int by) {
        super();
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
    }
    
}
