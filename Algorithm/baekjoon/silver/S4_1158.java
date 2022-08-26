package baekjoon.silver;

import java.io.*;
import java.util.*;
public class S4_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken());
		int stride = Integer.parseInt(str.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		int cnt=0;
		
		sb.append("<");
		for(int i=1;i<=N;i++)
			queue.add(i);
		while(queue.size()!=1) {
			int now = queue.poll();
			cnt++;
			if(cnt==stride) {
				sb.append(now+", ");
				cnt=0;
				
				continue;
			}
			queue.add(now);
		}
		sb.append(queue.poll()+">");
		System.out.println(sb);
	}
}