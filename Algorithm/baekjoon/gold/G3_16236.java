package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G3_16236 {
	static class Pos{
		int x, y, cnt;
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static List<Pos> fish;
	static Pos babyshark;
	static int fish_cnt,N,baby_size,shar_move,map[][], dx[] = {-1,0,1,0}, dy[] = {0,-1,0,1}; // 상 좌 하 우
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(str.nextToken());
		map = new int[N][N];
		fish = new ArrayList<Pos>();
		fish_cnt=0;
		shar_move=0;
		for(int i=0;i<N;i++) {
			str = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				int now = map[i][j] = Integer.parseInt(str.nextToken());
				if(now==9) {
					babyshark = new Pos(i, j, 0);
					baby_size = 2;
				}
				else if(now>=1 &&now<=6) {
					fish.add(new Pos(i, j, 0));
					fish_cnt++;
				}
			}
		}
		attack();
		System.out.println(shar_move);
	}
	public static void attack() {
		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.add(babyshark);
		int fish_kill = 0;
		boolean [][] map_check = new boolean[N][N];
		map[babyshark.x][babyshark.y] = 0;
		map_check[babyshark.x][babyshark.y] = true;
		while(true) {			
			List<Pos> can_eat = new ArrayList<Pos>();
			while(!queue.isEmpty()) {
				Pos now = queue.poll();
				int now_cnt = now.cnt;
				boolean yn=false;
				for(int i=0;i<4;i++) {
					int temp_x = now.x+dx[i], temp_y = now.y+dy[i];
					if(temp_x<0 || temp_y<0 || temp_x>=N||temp_y>=N||map[temp_x][temp_y]>baby_size || map_check[temp_x][temp_y])
						continue;
					else {
						queue.add(new Pos(temp_x, temp_y, now_cnt+1));
						map_check[temp_x][temp_y] = true;
						if(map[temp_x][temp_y]>0 && map[temp_x][temp_y]<=6 && map[temp_x][temp_y]<baby_size) {
							can_eat.add(new Pos(temp_x, temp_y, now_cnt+1));
						}
					}
				}
			}
			
			if(can_eat.size()==0) return;
			
			int min_x = 21, min_y = 21, min_dist = Integer.MAX_VALUE;

			for(Pos fish_now:can_eat) {
				if(min_dist>fish_now.cnt) {
					min_x = fish_now.x;
					min_y = fish_now.y;
					min_dist = fish_now.cnt;
				} else if(min_dist==fish_now.cnt) {
					if(min_x>fish_now.x || (min_x==fish_now.x && min_y>fish_now.y)) {
						min_x = fish_now.x;
						min_y = fish_now.y;
					}
				}
			}
			
			map[min_x][min_y]=0;
			fish_kill++;
			if(fish_kill==baby_size) {
				fish_kill=0;
				baby_size++;
			}
			shar_move+=min_dist;
			queue.clear();
			queue.add(new Pos(min_x, min_y, 0));
			map_check = new boolean[N][N];
			map_check[min_x][min_y] = true;
		}
		
	}
}