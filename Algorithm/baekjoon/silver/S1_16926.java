package baekjoon.silver;

import java.io.*;
import java.util.*;
public class S1_16926 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken()),
				R = Integer.parseInt(str.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(str.nextToken());
		}
		int rotation_num = Math.min(M, N)/2;
		for(int rotation_test = 0;rotation_test<R;rotation_test++) {
			for(int rotation = 0;rotation<rotation_num;rotation++) {
				int dir = 0, len = 0, x = rotation, y=rotation;
				int first = map[x][y];
				while(true) {
					int temp_x=x+dx[dir];
					int temp_y=y+dy[dir];
					if(temp_x<rotation || temp_y<rotation || temp_x>=N-rotation || temp_y>=M-rotation)
						dir++;
					if(dir==4) break;
					map[x][y] = map[x+dx[dir]][y+dy[dir]];
					x=x+dx[dir];
					y=y+dy[dir];
				}
				map[rotation+1][rotation]=first;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
}