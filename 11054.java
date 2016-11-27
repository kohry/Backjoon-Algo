package b11054;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] map;
	static int[] d1, d2;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Throwable {

		System.setIn(new FileInputStream("11054.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		map = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken());

		}

		list = new ArrayList<>();

		d1 = new int[N + 1];
		d2 = new int[N + 1];

		list.add(map[1]);

		for (int i = 2; i <= N; i++) {
			int index = Collections.binarySearch(list, map[i]);
			index = index >= 0 ? index : -index - 1;
			if (index > list.size() - 1)
				list.add(map[i]);
			else
				list.set(index, map[i]);

			d1[i] = list.size();

		}

		list.clear();

		list.add(map[N]);

		for (int i = N; i >= 2; i--) {
			int index = Collections.binarySearch(list, map[i]);
			index = index >= 0 ? index : -index - 1;
			if (index > list.size() - 1)
				list.add(map[i]);
			else
				list.set(index, map[i]);

			d2[i] = list.size();

		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

		for (int i = 1; i <= N; i++) {
			pq.add(d1[i] + d2[i] - 1);
		}

		System.out.println(pq.poll());

	}
}
