package baekjoon.silver;

import java.io.*;
import java.util.*;

public class S2_1927 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		Queue<Integer> min_heap = new PriorityQueue<Integer>();
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(in.readLine());
			if(now==0) {
				if(min_heap.isEmpty()) sb.append(0+"\n");
				else sb.append(min_heap.poll()+"\n");
			} else min_heap.add(now);
		}
		System.out.println(sb);
	}
}
