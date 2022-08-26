package baekjoon.silver;

import java.io.*;
import java.util.*;

public class S4_2164 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=T;i++)
			queue.add(i);
		while(queue.size()>1) {
			queue.remove();
			queue.add(queue.remove());
		}
		System.out.println(queue.remove());
	}
}
