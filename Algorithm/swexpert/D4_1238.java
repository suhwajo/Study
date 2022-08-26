package swexpert;

import java.io.*;
import java.util.*;
public class D4_1238 {
	static boolean[] call;
	static Node[] adjList;
	static int[] visited_height;
	static class Node{
		int to;
		Node next;
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int test=1;test<=10;test++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			call = new boolean[101];
			Arrays.fill(call, true);
			int N = Integer.parseInt(str.nextToken());
			int start =Integer.parseInt(str.nextToken());
			visited_height = new int[101];
			adjList = new Node[101];
			str = new StringTokenizer(in.readLine());
			for(int i=0;i<N/2;i++) {
				int from = Integer.parseInt(str.nextToken());
				int to = Integer.parseInt(str.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				call[from] = false;
				call[to] = false;
			}
			sb.append("#"+test+" "+bfs(start)+"\n");
		}
		System.out.println(sb);
	}
	private static int bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		int max = 1;
		visited_height[start] = 1;
		call[start] = true;
		queue.offer(start);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(Node temp = adjList[cur];temp!=null;temp = temp.next) {
				if(!call[temp.to]) {
					call[temp.to] = true;
					max = visited_height[temp.to] = visited_height[cur]+1;
					queue.offer(temp.to);
				}
			}
		}
		int result = -1;
		for(int i=0;i<101;i++) {
			if(visited_height[i]==max && i>result) result = i; 
		}
		return result;
	}
}