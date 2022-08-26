package swexpert;

import java.io.*;
import java.util.*;
public class D4_3289 {
	static int parents[], n;
	public static void make() {
		parents = new int[n+1];
		for (int i = 0; i < n; i++)	parents[i] = i;
	}
	public static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		boolean same = parents_same(a, b);
		int finda = find(a);
		int findb = find(b);
		
		if(finda == findb) return false;
		parents[findb] = finda;
		return true;
	}
	public static boolean parents_same(int a, int b) {
		int finda = find(a);
		int findb = find(b);
		
		if(finda == findb) return true;
		return false;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			StringTokenizer str = new StringTokenizer(in.readLine());
			n = Integer.parseInt(str.nextToken());
			int m = Integer.parseInt(str.nextToken());
			make();
			for (int i = 0; i < m; i++) {
				str = new StringTokenizer(in.readLine());
				int recom = Integer.parseInt(str.nextToken());
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				if(recom==0) {
					union(a, b);
				}else {
					if(parents_same(a, b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}