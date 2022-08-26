package baekjoon.silver;

import java.io.*;
import java.util.*;

public class S2_11279 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(in.readLine());
			if(now==0) {
				if(queue.isEmpty()) sb.append(0+"\n");
				else sb.append(queue.poll()+"\n");
			} else queue.add(now);
		}
		System.out.println(sb);
	}
}
