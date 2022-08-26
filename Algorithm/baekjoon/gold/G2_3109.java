package baekjoon.gold;
import java.io.*;
import java.util.*;
public class G2_3109 {
	static int[] dx = {-1,0,1}, dy = {1,1,1};
	static int R, C, count;
	static char[][] map;
	static boolean map_bool[][], yn;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		map = new char[R][C];
		count=0;
		for(int i=0;i<R;i++) {
			String line = in.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = line.charAt(j);
			}
		}
		map_bool = new boolean[R][C];
		for(int i=0;i<R;i++) {
			yn=false;
			gas(i,0);
		}
		System.out.println(count);
	}
	private static void gas(int x, int y) {
		if(yn || x<0 || y<0 || x>=R || y>=C || map[x][y]=='x' || map_bool[x][y]) {
			if(!yn && y>=C) {
				count++;
				yn=true;
			}
			return;
		}
		map_bool[x][y]=true;
		for(int i=0;i<3;i++) {
			gas(x+dx[i], y+dy[i]);
		}
	}
}
