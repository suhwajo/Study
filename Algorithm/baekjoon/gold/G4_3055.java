package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G4_3055 {
	static int R, C, dx[] = {0,-1,0,1}, dy[] = {-1,0,1,0};
	static char map[][];
	static int water_map[][];
	static Pos D, S;
	static List<Pos> water;
	static int yn;
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		map = new char[R][C];
		water = new ArrayList<Pos>();
		water_map = new int[R][C];
		for(int i=0;i<R;i++) {
			String line = in.readLine();
			for(int j=0;j<C;j++) {
				char now = line.charAt(j);
				map[i][j] = now;
				if(now=='*') {
					water.add(new Pos(i, j));
					water_map[i][j] = 1;
				}
				else if(now=='S') S = new Pos(i, j);
				else if(now == 'D') {
					D = new Pos(i, j);
					water_map[i][j] = -1;
				}else if(now=='X') water_map[i][j] = -1;
			}
		}
		for(int i=0;i<water.size();i++)
			bfs(water.get(i).x, water.get(i).y);

		yn=0;
		bfs_S(S.x,S.y);
		if(yn!=0) System.out.println(yn-1);
		else System.out.println("KAKTUS");
	}
	
	private static void bfs(int x, int y) {
		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.add(new Pos(x, y));
		int cnt=2;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			for(int i=0;i<4;i++) {
				int temp_x = now.x+dx[i], temp_y = now.y+dy[i];
				if(temp_x<0 || temp_y<0||temp_x>=R || temp_y>=C || water_map[temp_x][temp_y]!=0) continue;
				water_map[temp_x][temp_y] = water_map[now.x][now.y]+1;
				queue.add(new Pos(temp_x, temp_y));
			}
		}		
	}

	private static void bfs_S(int x, int y) {
		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.add(new Pos(x, y));
		int[][]S_map = new int [R][C];
		S_map[x][y] = 1;
		int min= Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			for(int i=0;i<4;i++) {
				int temp_x = now.x+dx[i], temp_y = now.y+dy[i];
				if(temp_x<0 || temp_y<0||temp_x>=R || temp_y>=C
						|| S_map[temp_x][temp_y]!=0 || map[temp_x][temp_y]=='X'||
						(water_map[temp_x][temp_y]>1 && S_map[now.x][now.y]+1>=water_map[temp_x][temp_y]))
					continue;
				if(map[temp_x][temp_y]=='D') {
					yn=S_map[temp_x][temp_y] = S_map[now.x][now.y]+1;
					return;
				}
				S_map[temp_x][temp_y] = S_map[now.x][now.y]+1;
				queue.add(new Pos(temp_x, temp_y));
			}
		}
	}
}