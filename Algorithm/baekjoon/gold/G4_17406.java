package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G4_17406 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0}, numbers;
	static boolean[] isSlected;
	static int[][] permutation, recom;
	static int cnt=0, K, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(str.nextToken());
		}
		int facto_k=facto(K);
		permutation = new int[facto_k][K];
		isSlected = new boolean[K];
		numbers = new int[K];
		recom = new int[K][5];//x : 0, 2 & y : 1, 3 rotation 4
		
		for(int i=0;i<K;i++) {
			str = new StringTokenizer(in.readLine());
			int[] rcs = new int[3];
			for(int j=0;j<3;j++) rcs[j] = Integer.parseInt(str.nextToken());
			recom[i][0] = rcs[0]-rcs[2]-1;
			recom[i][1] = rcs[1]-rcs[2]-1;
			recom[i][2] = rcs[0]+rcs[2]-1;
			recom[i][3] = rcs[1]+rcs[2]-1;
			recom[i][4] = Math.min(recom[i][2]-recom[i][0], recom[i][3]-recom[i][1])/2;
		}
		
		perm(0);
		int min=Integer.MAX_VALUE;
		for(int i=0;i<facto_k;i++) {
			int now = array_rot(map, permutation[i]);
			min = Math.min(now, min);
			
		}
		System.out.println(min);
			
	}
	
	public static int facto(int n) {
		if(n==1) return 1;
		return facto(n-1)*n;
	}
	
	public static void perm(int n) {
		if(n==K) {
			for(int i=0;i<K;i++)
				permutation[cnt][i] = numbers[i];
			cnt++;

			return;
		}
		for(int i=0;i<K;i++) {
			if(isSlected[i]) continue;
			numbers[n]=i;
			isSlected[i] = true;
			perm(n+1);
			isSlected[i] = false;
			
		}
	}
	
	public static int array_rot(int[][] map, int[] perm){
		int[][] result = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				result[i][j] = map[i][j];
		}
		
		for(int rotation_test = 0;rotation_test<K;rotation_test++) {
			for(int rotation = 0;rotation<recom[perm[rotation_test]][4];rotation++) {
				int dir = 0, x = recom[perm[rotation_test]][0]+rotation, y=recom[perm[rotation_test]][3]-rotation;
				int first = result[x][y];
				while(true) {
					int temp_x=x+dx[dir];
					int temp_y=y+dy[dir];
					if(temp_x<recom[perm[rotation_test]][0]+rotation || temp_y<recom[perm[rotation_test]][1]+rotation || temp_x>recom[perm[rotation_test]][2]-rotation || temp_y>recom[perm[rotation_test]][3]-rotation)
						dir++;
					if(dir==4) break;
					result[x][y] = result[x+dx[dir]][y+dy[dir]];
					x=x+dx[dir];
					y=y+dy[dir];
				}
				result[recom[perm[rotation_test]][0]+rotation+1][recom[perm[rotation_test]][3]-rotation]=first;
			}	
		}
		
		int min = checking(result);
		
		return min;
	}
	
	public static int checking(int[][]map) {
		int min=Integer.MAX_VALUE, sum;
		for(int i=0;i<N;i++) {
			sum=0;
			for(int j=0;j<M;j++) {
				sum+=map[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}
}