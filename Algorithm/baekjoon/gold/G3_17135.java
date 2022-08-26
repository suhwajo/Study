package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G3_17135 {
	static int N, M, D, map_copy[][], kill,map[][], delete_min, delete_x, delete_y, archer_x, archer_y;
	static int[] dx = {0,-1,0}, dy = {-1,0,1};
	static boolean yn, kill_bool[][];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int max = Integer.MIN_VALUE;
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		D = Integer.parseInt(str.nextToken());
		map_copy = new int[N][M];
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			str = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) map[i][j] = Integer.parseInt(str.nextToken());
		}
		int[] input = new int[M];
		int[] numbers = new int[3];
		for(int i=0;i<M;i++) {
			input[i] = i;
		}
		int[] P = new int[M];
		int cnt = 0;
		while (++cnt <= 3) {
			P[M - cnt] = 1;
		}
		do {
			int cursor = 0;
			for (int i = 0; i < M; i++) {
				if (P[i] == 1) {
					numbers[cursor++] = input[i];
				}
			}
			kill=0;
			kill_bool = new boolean[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++)
					map_copy[i][j] = map[i][j];
			}
			attack(numbers, N-1);
			if(kill>max) max=kill;
		} while(np(P));
		System.out.println(max);
	}
	
	public static void attack(int[] numbers, int archer_linenum) {
		if(archer_linenum<0) return;
		for(int i=0;i<3;i++) {
			archer_x = archer_linenum;
			archer_y = numbers[i];
			delete_min = Integer.MAX_VALUE;
			delete_x = -1;
			delete_y = -1;
			dfs(archer_linenum, numbers[i], 1);
			if(delete_x!=-1 && delete_y!=-1 && map[delete_x][delete_y]==1 && map_copy[delete_x][delete_y]==1) {
				kill++;
				map_copy[delete_x][delete_y] = 0;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				if(map_copy[i][j] != map[i][j])kill_bool[i][j] = true;
		}
		attack(numbers, archer_linenum-1);
	}
	
	public static int distance(int enemy_x, int enemy_y) {
		return (int)Math.abs(archer_x-enemy_x)+(int)Math.abs(archer_y-enemy_y);
	}
	
	public static void dfs(int x, int y, int cnt) {
		
		if(cnt>D || x<0 || y<0 ||x>=N ||y>=M) return;
		if(cnt<=D && !kill_bool[x][y] && map[x][y]==1 ) {
			int now_dist = distance(x, y);
			if(delete_min>now_dist) {
				delete_x = x;
				delete_y = y;
				delete_min = now_dist;
			}
			return;
		}
		for(int i=0;i<3;i++) {
			dfs(x+dx[i],y+dy[i], cnt+1);
		}
	}
	
	
	public static boolean np(int[] numbers) { 
		int N = numbers.length;
		int i=N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		if(i==0) return false; 
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;
		swap(numbers, i-1, j);
		int k = N-1;
		while(i<k) swap(numbers, i++, k--);
		return true;
	}
	public static void swap(int[]numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}