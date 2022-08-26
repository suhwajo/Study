package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G4_4485 {
	static int map[][], N, min;
	static int dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};
	static class Pos implements Comparable<Pos>{
		int x, y, rupee_sum;
		public Pos(int x, int y, int rupee_sum) {
			this.x = x;
			this.y = y;
			this.rupee_sum = rupee_sum;
		}
		@Override
		public int compareTo(Pos o) {
			return this.rupee_sum-o.rupee_sum;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		int cnt = 1;
		while((N = Integer.parseInt(in.readLine()))!=0){
			sb.append("Problem "+(cnt++)+": ");
			min = Integer.MAX_VALUE;
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer str = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(str.nextToken());
			}
			
			int min_edge[][] = new int[N][N];
			boolean min_check[][] = new boolean[N][N];
			int max = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) Arrays.fill(min_edge[i], max);
			min_edge[0][0] = 0;
			Queue<Pos> queue = new PriorityQueue<Pos>();
			queue.add(new Pos(0, 0, map[0][0]));
			while(!queue.isEmpty()) {
				Pos now = queue.poll();
				min_check[now.x][now.y] = true;
				for(int i=0;i<4;i++) {
					int tempx = now.x+dx[i], tempy = now.y+dy[i];
					
					if(tempx<0||tempy<0||tempx>=N||tempy>=N||min_check[tempx][tempy]
							|| min_edge[tempx][tempy]<now.rupee_sum)
						continue;
					if(min_edge[tempx][tempy]>now.rupee_sum+map[tempx][tempy]) {
						min_edge[tempx][tempy] = now.rupee_sum+map[tempx][tempy];
						queue.offer(new Pos(tempx, tempy, min_edge[tempx][tempy]));
					}
				}
			}
			sb.append(min_edge[N-1][N-1]+"\n");
		}
		System.out.println(sb);
	}
}