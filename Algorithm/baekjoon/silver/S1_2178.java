package baekjoon.silver;

import java.io.*;
import java.util.*;
public class notdoneS1_2178 {
	static int N, M, min, dir;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		map = new int[N][M];
		min=Integer.MAX_VALUE;
		dir=0;
		for(int i=0;i<N;i++) {
			String line = in.readLine();
			for(int j=0;j<M;j++)
				map[i][j] = line.charAt(j)-'0';
		}
		bfs(0, 0, 1);
		System.out.println(min);
	}
	public static void bfs(int x, int y, int cnt) {
		if((x==N-1 && y==M-1) || x<0 || y<0 || x>=N || y>=M || map[x][y]==0) {
			if(x==N-1 && y==M-1)
				min = Math.min(min, cnt);
			return;
		}
		for(int i=0;i<4;i++) {
			if((i+6%4)==dir) continue;
			dir=i;
			
			bfs(x+dx[i],y+dy[i],cnt+1);
		}
	}

}
