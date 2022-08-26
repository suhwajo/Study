package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G5_7576 {
	static public class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static List<Pos> tomato;
	static int min,N, M, dx[] = {0,0,1,-1}, dy[] = {-1,1,0,0}, map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());
		map = new int[N][M];
		tomato = new ArrayList<Pos>();
		for(int i=0;i<N;i++) {
			str = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				int now = map[i][j] = Integer.parseInt(str.nextToken());
				if(now == 1) {
					tomato.add(new Pos(i,j));
				}
			}
		}
		boolean dul_tomato = false;
		min=0;
		bfs();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) dul_tomato = true;
			}
		}
		if(dul_tomato) System.out.println(-1);
		else System.out.println(min);
	}
	private static void bfs() {
		Queue<Pos> queue = new ArrayDeque<Pos>();
		for(Pos start_tomato: tomato)queue.add(start_tomato);
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			for(int i=0;i<4;i++) {
				int tempx = now.x+dx[i], tempy = now.y+dy[i];
				if(tempx<0 || tempy<0 || tempx>=N || tempy>=M || map[tempx][tempy]!=0)
					continue;
				queue.add(new Pos(tempx, tempy));
				map[tempx][tempy] = map[now.x][now.y]+1;
			}
			min = map[now.x][now.y]-1;
		}
	}
}