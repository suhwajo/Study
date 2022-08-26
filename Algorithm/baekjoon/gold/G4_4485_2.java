package baekjoon.gold;

import java.io.*;
import java.util.*;

public class G4_4485_2 {
	public static class Pos implements Comparable<Pos>{
		int x, y, weight;
		public Pos(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pos o) {
			return this.weight-o.weight;
		}
		
	}
	
	static int dx[] = {1,0,-1,0},dy[] = {0,1,0,-1}, map[][], N;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while((N = Integer.parseInt(in.readLine()))!=0) {
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer str = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			
			
			System.out.println(find_root());
		}

	}

	private static int find_root() {
		Queue<Pos> queue = new PriorityQueue<Pos>();
		queue.add(new Pos(0, 0, map[0][0]));
		int temp_map[][] = new int[N][N];
		boolean[][] map_bool = new boolean[N][N];

		for (int i = 0; i < N; i++) Arrays.fill(temp_map[i], Integer.MAX_VALUE);
		
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			int nowx = now.x, nowy = now.y;
			map_bool[nowx][nowy] = true;
			if(nowx==N-1 && nowy==N-1) return temp_map[nowx][nowy];
			
			for(int i=0;i<4;i++) {
				int tempx = nowx+dx[i], tempy = nowy+dy[i];
				if(tempx<0 || tempy<0 || tempx>=N ||tempy>=N || map_bool[tempx][tempy])
					continue;
				
				if(temp_map[tempx][tempy]>now.weight+map[tempx][tempy]) {
					queue.add(new Pos(tempx, tempy, now.weight+map[tempx][tempy]));
					temp_map[tempx][tempy] = now.weight+map[tempx][tempy];
				}
			}
		}
		return temp_map[N-1][N-1];
	}

}
