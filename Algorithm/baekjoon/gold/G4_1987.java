package baekjoon.gold;
import java.io.*;
import java.util.*;
public class G4_1987 {
	static int R, C, map[][], max;
	static boolean isSelected[];
	static int[] dx = {0,-1,0,1}, dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		max=-1;
		map = new int[R][C];
		isSelected = new boolean[26];
		for(int i=0;i<R;i++) {
			String line = in.readLine();
			for(int j=0;j<C;j++)
				map[i][j] = line.charAt(j)-'A';
		}
		horse(0,0,0);
		System.out.println(max);
	}
	private static void horse(int cnt, int x, int y) {
		if(x<0 || y<0 || x>=R || y>=C || isSelected[map[x][y]]) {
			if(max<cnt) max=cnt;
			return;
		}
		isSelected[map[x][y]] = true;
		for(int i=0;i<4;i++) {
			horse(cnt+1, x+dx[i], y+dy[i]);
		}
		isSelected[map[x][y]] = false;
	}
}