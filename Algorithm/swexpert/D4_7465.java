package swexpert;

import java.io.*;
import java.util.*;
public class D4_7465 {
	static int parents[], N;
	public static class Edge{
		int from, to;
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	static void make() {
		parents = new int[N];
		for(int i=0;i<N;i++) parents[i] = i;
	}
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int finda = find(a);
		int findb = find(b);
		if(finda==findb) return false;
		parents[findb] = finda;
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(str.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			str = new StringTokenizer(in.readLine());
			N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			boolean[] check = new boolean[N];
			Edge[] edgelist = new Edge[M];
			for(int i=0;i<M;i++) {
				str = new StringTokenizer(in.readLine());
				edgelist[i] = new Edge(Integer.parseInt(str.nextToken())-1, Integer.parseInt(str.nextToken())-1);
			}
			make();
			for(Edge edge:edgelist) {
				union(edge.from, edge.to);
			}
			
			for(int i=0;i<N;i++) {
				find(i);
			}
			
			for(int i=0;i<N;i++) {
				check[parents[i]] = true;
			}
			int cnt=0;
			for(int i=0;i<N;i++) {
				if(check[i]) cnt++;
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
}