package baekjoon.silver;

import java.io.*;
import java.util.*;
public class S2_10971 {
	static int travel_map[][], N, start, min;
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(str.nextToken());
		travel_map = new int[N][N];
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				travel_map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			visited = new boolean[N];
			visited[i] = true;
			start = i;
			dfs(i, 1, 0);
		}
		System.out.println(min);
	}
	private static void dfs(int now, int cnt, int sum) {
		if(cnt==N) {
			if(travel_map[now][start]==0) return;
			sum+=travel_map[now][start];
			min = Math.min(sum, min);
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i] || travel_map[now][i]==0) continue;
			visited[i] = true;
			dfs(i, cnt+1, sum+travel_map[now][i]);
			visited[i] = false;
		}
	}
}