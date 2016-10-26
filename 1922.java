package b1922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    static int N, M;
    static ArrayList<ArrayList<Vertex>> list = new ArrayList<>();
    static ArrayList<V> l = new ArrayList<>();
    static ArrayList<V> result = new ArrayList<>();
    static int[][] visited = new int[1001][1001];

    public static void main(String[] args) throws Throwable {

        System.setIn(new FileInputStream("1922.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Vertex>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Vertex(b, c));
            list.get(b).add(new Vertex(a, c));
            l.add(new V(a, b, c));
        }

        Collections.sort(l, new Comparator<V>() {

            @Override
            public int compare(V arg0, V arg1) {
                // TODO Auto-generated method stub
                return arg0.c - arg1.c;
            }

        });

        int distance = 0;
        NativeDisjointSet nds = new NativeDisjointSet(N);
        for (int i = 0; i < M; i++) {

            int u = l.get(i).a;
            int v = l.get(i).b;

            if (nds.find(u) == nds.find(v)) {
                continue;
            }
            nds.union(u, v);

            distance = distance + l.get(i).c;
            result.add(new V(u, v, l.get(i).c));

        }
        System.out.println(distance);

    }
}

class V {
    int a;
    int b;
    int c;

    public V(int a, int b, int c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

}

class Vertex {
    int t;
    int d;

    public Vertex(int t, int d) {
        super();
        this.t = t;
        this.d = d;
    }

}

class NativeDisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();

    public NativeDisjointSet(int n) {

        for (int i = 0; i < n + 1; i++) {
            parent.add(i, i);
        }
    }

    public int find(int u) {
        if (u == parent.get(u))
            return u;
        return find(parent.get(u));
    }

    public void union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (a == b)
            return;
        parent.set(a, b);
    }

}
