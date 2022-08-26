package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G5_10026 {
	public static int N, dx[] = {1,-1,0,0}, dy[] = {0,0,1,-1};
	static public class Pos{
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
		N = Integer.parseInt(str.nextToken());
		char[][] no_weakness = new char[N][N], weakness = new char[N][N];
		boolean[][] no_weakness_bool = new boolean[N][N], weakness_bool = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String line = in.readLine();
			for(int j=0;j<N;j++) {
				char now = line.charAt(j);
				no_weakness[i][j] = now;
				if(now=='G') weakness[i][j] = 'R';
				else weakness[i][j] = now;
			}
		}
		int weak = 0, no_weak = 0;				
		for(int i =0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!no_weakness_bool[i][j]) {
					no_weakness_bool = find_set(i, j, no_weakness[i][j], no_weakness_bool, no_weakness);		
					no_weak++;
				}
				if(!weakness_bool[i][j]) {
					weakness_bool = find_set(i, j, weakness[i][j], weakness_bool, weakness);		
					weak++;
				}
			}
		}
		sb.append(no_weak+" "+weak);
		System.out.println(sb);
	}
	private static boolean[][] find_set(int x, int y, char now_color, boolean[][] bool, char[][] no_weakness) {

		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.add(new Pos(x, y));
		bool[x][y] = true;
		
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			for(int i=0;i<4;i++) {
				int tempx = now.x+dx[i], tempy = now.y+dy[i];
				if(tempx<0 || tempy<0||tempx>=N ||tempy>=N||bool[tempx][tempy] || no_weakness[tempx][tempy]!=now_color)
					continue;
				queue.add(new Pos(tempx, tempy));
				bool[tempx][tempy] = true;
			}
		}
		return bool;
	}
}