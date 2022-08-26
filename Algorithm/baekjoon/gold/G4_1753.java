package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G4_1753 {
	static class Node{
		int to, weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(str.nextToken());
		int E = Integer.parseInt(str.nextToken());
		int startV = Integer.parseInt(in.readLine());
		ArrayList<Node>[] list = new ArrayList[V+1];
		
		for(int i=1;i<V+1;i++) list[i] = new ArrayList<>();
		for (int Enum = 0; Enum < E; Enum++) {
			str = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(str.nextToken());
			int to = Integer.parseInt(str.nextToken());
			int weight = Integer.parseInt(str.nextToken());
			list[from].add(new Node(to, weight));
		}
		
		int min_weight[] = new int[V+1];
		Arrays.fill(min_weight, Integer.MAX_VALUE);
		PriorityQueue<Node> pque = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.weight,  o2.weight));
		pque.offer(new Node(startV, 0));
		min_weight[startV] = 0;
		while(!pque.isEmpty()) {
			Node now = pque.poll();
			
			if(min_weight[now.to]<now.weight) continue;
			for(int i=0, size = list[now.to].size();i<size;i++) {
				Node next = list[now.to].get(i);
				if(min_weight[next.to]>now.weight+next.weight) {
					min_weight[next.to] = now.weight+next.weight;
					pque.offer(new Node(next.to, min_weight[next.to]));
				}
			}
		}
		for(int i=1;i<V+1;i++) {
			if(min_weight[i]==Integer.MAX_VALUE)
				sb.append("INF\n");
			else sb.append(min_weight[i]+"\n");
		}
		System.out.println(sb);
	}
}