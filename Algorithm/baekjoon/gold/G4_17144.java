package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G4_17144 {
	public static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static List<Pos> dust, cleaner;
	static int dx[] = {-1,0,1,0}, dy[] = {0,1,0,-1}, R, C, T, map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		T = Integer.parseInt(str.nextToken());
		map = new int[R][C];
		cleaner = new ArrayList<Pos>();
		for(int i=0;i<R;i++) {
			str = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if(map[i][j]==-1) cleaner.add(new Pos(i, j));
			}
		}
		
		for(int i=0;i<T;i++) {
			check_dust();
			spread();
			clean();
		}
		int dust_remain = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) dust_remain+=map[i][j];
		}
		System.out.println(dust_remain+2);
	}
	
	private static void clean() {
		int x = cleaner.get(0).x-1, y = 0, dir=0;
		while(true) {
			int tempx = x+dx[dir], tempy=y+dy[dir];
			if(tempx<0 || tempy<0 ||tempx>cleaner.get(0).x || tempy>=C) {
				dir++;
				dir %= 4;
				tempx = x+dx[dir];
				tempy=y+dy[dir];
			} else if(map[tempx][tempy]==-1) {
				map[x][y] = 0;
				break;
			}
			map[x][y] = map[tempx][tempy];
			x = tempx;
			y = tempy;
		}
		x = cleaner.get(1).x+1;
		y = 0;
		dir=2;
		while(true) {
			int tempx = x+dx[dir], tempy=y+dy[dir];
			if(tempx<cleaner.get(1).x || tempy<0 ||tempx>=R || tempy>=C) {
				dir--;
				dir = (dir+4)%4;
				tempx = x+dx[dir];
				tempy=y+dy[dir];
			} else if(map[tempx][tempy]==-1) {
				map[x][y] = 0;
				break;
			}
			map[x][y] = map[tempx][tempy];
			x = tempx;
			y = tempy;
		}
	}
	private static void check_dust() {
		dust = new ArrayList<Pos>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0)dust.add(new Pos(i, j));
			}
		}
	}
	
	private static void spread() {
		int [][] dust_change = new int[R][C];
		dust_change[cleaner.get(0).x][0] = -1;
		dust_change[cleaner.get(1).x][0] = -1;
		
		for(int dust_num=0;dust_num<dust.size();dust_num++) {
			Pos now = dust.get(dust_num);
			int now_dust_size =map[now.x][now.y]; 
			if(now_dust_size<5 && now_dust_size>0) {
				dust_change[now.x][now.y] += now_dust_size;
				continue;
			}
			int spread = map[now.x][now.y]/5;
			int spread_num = 0;
			for(int i=0;i<4;i++) {
				int tempx = now.x+dx[i], tempy=now.y+dy[i];
				if(tempx<0 || tempy<0 ||tempx>=R || tempy>=C || map[tempx][tempy]==-1)
					continue;
				dust_change[tempx][tempy]+=spread;
				spread_num++;
			}
			dust_change[now.x][now.y]+=now_dust_size-(spread_num*spread);
		}
		map = dust_change;
	}

}