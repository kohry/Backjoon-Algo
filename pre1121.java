
package pre;

import java.io.BufferedReader;

import java.io.FileInputStream;

import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int TestCase;
	static int N, M, K;
	static ArrayList<ArrayList<Point>> list = new ArrayList<>();
	static double result;

	public static void main(String[] args) throws Throwable {

		System.setIn(new FileInputStream("1114.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TestCase = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TestCase; testCase++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			list.clear();
			result = 0;

			for (int i = 0; i <= N; i++) {

				list.add(new ArrayList<>());

			}

			for (int i = 1; i <= K; i++) {

				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				double p = Double.parseDouble(st.nextToken());

				list.get(a).add(new Point(a, b, p));

			}

			calc(1, 0, 1, 1, 0, N, 1);

			System.out.printf("#%d %.3f \n", testCase, result);

		}

	}

	public static void calc(int n, int prevm, int nowm, double perm, int prevf, int nowf, double perf) {

		if (n == M + 1)
			return;

		// 만날때
		if (nowm == nowf) {
			result = result + perm * perf;
			return;
		}

		for (Point pm : list.get(nowm)) {
			for (Point pf : list.get(nowf)) {
				calc(n + 1, nowm, pm.y, perm * pm.p, nowf, pf.y, perf * pf.p);
			}
		}

	} // end calc

}

class Point {

	int x;
	int y;
	double p;

	public Point(int x, int y, double p) {

		super();
		this.x = x;
		this.y = y;
		this.p = p;

	}

}
