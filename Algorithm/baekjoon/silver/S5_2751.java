package baekjoon.silver;

import java.io.*;
import java.util.*;

public class S5_2751{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0;i<N;i++) queue.add(Integer.parseInt(in.readLine()));
		for(int i=0;i<N;i++) sb.append(queue.poll()+"\n");
		System.out.println(sb);
	}

}
