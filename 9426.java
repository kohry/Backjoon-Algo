package b9426;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] temp;
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws Throwable{
		
		System.setIn(new FileInputStream("9426.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		temp = new int[N+1];
		arr  = new ArrayList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			temp[i] = Integer.parseInt(br.readLine());
		}
		
		int center = ((K+1)/2);
		
		arr.add(0);
		for (int i = 1; i <= K; i++) arr.add(temp[i]);
		
		Collections.sort(arr);
		
		int sum = arr.get(center);
		for (int i = 1; i <= N - K; i++) { 
			
			int index = Collections.binarySearch(arr, temp[i]);
			arr.remove(index);
			
			index = Collections.binarySearch(arr, temp[i+K]);
			if (index < 0) {
				index = (-index)-1;
			} 
			
			arr.add(index,temp[i+K]);
			
			int mid = arr.get(center);
			sum = sum + mid;
		}
		
		System.out.println(sum);
		
	}
}
