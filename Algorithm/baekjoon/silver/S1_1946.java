package baekjoon.silver;

import java.io.*;
import java.util.*;
public class S1_1946 {
	public static class Worker implements Comparable<Worker>{
		int first, second;
		public Worker(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		@Override
		public int compareTo(Worker o) {
			return this.first-o.first;
		}	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(str.nextToken());
		for(int test_case=0;test_case<T;test_case++) {
			str = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(str.nextToken());
			Worker[] new_worker = new Worker[N];
			for(int i=0;i<N;i++) {
				str = new StringTokenizer(in.readLine());
				new_worker[i] = new Worker(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
			}
			Arrays.sort(new_worker);
			int count=1, second_grade = new_worker[0].second;
			for(int i=1, size = new_worker.length;i<size;i++)
				if(new_worker[i].second<new_worker[i-1].second && new_worker[i].second<second_grade) {
					second_grade=new_worker[i].second;
					count++;
				}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
}