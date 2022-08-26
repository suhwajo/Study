package baekjoon.silver;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
public class S1_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)>Math.abs(o2)) return Math.abs(o1)-Math.abs(o2);
				else if(Math.abs(o1)==Math.abs(o2)) return o1-o2;
				return -1;
			}
		});
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(in.readLine());
			if(now==0) {
				if(heap.isEmpty()) sb.append(0+"\n");
				else sb.append(heap.poll()+"\n");
			} else heap.add(now);
		}
		System.out.println(sb);
	}
}