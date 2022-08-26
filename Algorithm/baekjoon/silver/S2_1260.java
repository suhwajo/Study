package baekjoon.silver;

import java.io.*;
import java.util.*;
public class S2_1260 {
	public static class Node{
		int to;
		Node next;
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
	}
	static Node[] graph;
	static int N, V;
	static boolean isSelected[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		V = Integer.parseInt(str.nextToken());
		graph = new Node[N+1];
		isSelected = new boolean[N+1];
		for(int i=0;i<M;i++) {
			str = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(str.nextToken()), to = Integer.parseInt(str.nextToken());
			graph[from] = new Node(to, graph[from]);
			graph[to] = new Node(from, graph[to]);
		}
		dfs(V);
		System.out.println(sb);
		sb = new StringBuilder();
		bfs();
		System.out.println(sb);

	}
	
	static public void dfs(int now) {
		isSelected[now] = true;
		List<Integer> list = new ArrayList<Integer>();
		int now_cnt=0;
		sb.append(now+" ");
		for(Node temp = graph[now];temp!=null;temp = temp.next) {
			list.add(temp.to);
			now_cnt++;
		}
		Collections.sort(list);
		for(int i=0;i<now_cnt;i++) {
			if(!isSelected[list.get(i)]) {
				dfs(list.get(i));
			}
		}
	}
	
	static public void bfs() {
		boolean[] isSelected = new boolean[N+1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(V);
		isSelected[V] = true;
		sb.append(V+" ");
		while(!queue.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int now = queue.poll();

			for(Node temp = graph[now];temp!=null;temp = temp.next) {
				if(!isSelected[temp.to]) {
					list.add(temp.to);
					isSelected[temp.to] = true;
				}
			}
			Collections.sort(list);
			for(int i=0, size = list.size();i<size;i++) {
				int num = list.get(i);
				queue.add(num);
				sb.append(num+" ");
			}
		}
	}
}