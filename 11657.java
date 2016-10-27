package b11657;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int INF = 200000000;
    static ArrayList<ArrayList<City>> list = new ArrayList<>();
    static int[] dist = new int[501];

    public static void main(String[] args) throws Throwable {
        System.setIn(new FileInputStream("11657.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= M; i++) {
            list.add(new ArrayList<City>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new City(a, b, c));
        }

        boolean minus = false;
        Arrays.fill(dist, INF);

        dist[0] = 0;
        dist[1] = 0;
        for (int i = 0; i < N; i++) {
            
            for (int j = 1; j < N; j++) {

                for (City city : list.get(j)) {
                    int next = city.b;
                    int d = city.c;

                    if (dist[j] != INF && dist[next] > dist[j] + d) {
                        dist[next] = dist[j] + d;
                        
                        if (i == N - 1)
                            minus = true;
                    }

                }

            }
        }
        
        if(minus) System.out.println("-1");
        else {
            for (int i = 2; i <= N; i++) {
                System.out.printf("%d\n", dist[i] != INF ? dist[i] : -1);
                
            }
        }

    }
}

class City {
    int a;
    int b;
    int c;

    public City(int a, int b, int c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

}
