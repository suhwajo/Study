package swexpert;

import java.util.*;
import java.io.*;
public class D4_1861 {
	static int[] dx = {-1,1,0,0}; // 상,하,좌,우
	static int[] dy = {0,0,-1,1};
	static int map[][];
	static int max_val, N, max,fx,fy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(str.nextToken());
		
		for(int test_case=1;test_case<=T;test_case++) {
			N = Integer.parseInt(new StringTokenizer(in.readLine()).nextToken());
			map= new int[N][N];
			for(int i=0;i<N;i++) {
				str = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++)
					map[i][j] = Integer.parseInt(str.nextToken());
			}
			max=0;
			max_val=0;

			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					fx=x;
					fy=y;
					find(x,y, map[x][y]-1, 0);
				}
			}
			sb.append("#"+test_case+" "+max_val+" "+max+"\n");
		}
		System.out.println(sb);
	}
	public static void find(int x, int y, int before, int cnt) {
		if(x>=N || x<0 || y>=N || y<0 || map[x][y]-before!=1) {
			if(cnt>max || (cnt==max && max_val>map[fx][fy])) {
				max=cnt;
				max_val=map[fx][fy];
			}
			return;
		}
		for(int i=0;i<4;i++) {
			find(x+dx[i],y+dy[i], map[x][y], cnt+1);
		}
	}
}