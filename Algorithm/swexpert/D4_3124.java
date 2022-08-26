package swexpert;

import java.io.*;
import java.util.*;
public class D4_3124 {
	static int parents[], V;
	public static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	public static void make() {
		parents = new int[V+1];
		for(int i=0;i<V;i++) parents[i] = i;
	}
	public static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	public static boolean union(int a, int b) {
		int finda = find(a);
		int findb = find(b);
		if(finda==findb) return false;
		
		parents[findb] = finda;
		return true;
				
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			sb.append("#"+test_case+" ");
			V = Integer.parseInt(str.nextToken());
			int E = Integer.parseInt(str.nextToken());
			Edge[] edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				str = new StringTokenizer(in.readLine());
				int A = Integer.parseInt(str.nextToken());
				int B = Integer.parseInt(str.nextToken());
				int W = Integer.parseInt(str.nextToken());
				edgeList[i] = new Edge(A, B, W);
			}
			make();
			Arrays.sort(edgeList);
			int edge_cnt = 0;
			long result = 0;
			for(Edge temp : edgeList) {
				if(union(temp.from, temp.to)) {
					result+=temp.weight;
					edge_cnt++;
				}
				if(edge_cnt==E-1) break;
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}