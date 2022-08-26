package baekjoon.silver;

import java.io.*;
import java.util.*;
public class S1_1697 {
	static int[] position = new int[100001];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		System.out.println(bfs(N, K));
	}
	private static int bfs(int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);	
		position[N]=1;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now==K) return position[now]-1;
			if(now-1>=0 && position[now-1]==0) {
				queue.add(now-1);
				position[now-1] = position[now]+1;
			}
			if(now+1<100001 && position[now+1]==0) {
				queue.add(now+1);
				position[now+1] = position[now]+1;
			}
			if(now*2<100001 && position[now*2]==0) {
				queue.add(now*2);
				position[now*2] = position[now]+1;
			}
		}
		return -1;
	}
}