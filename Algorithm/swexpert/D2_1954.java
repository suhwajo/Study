package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1954 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case=0;test_case<T;test_case++) {
			int N = Integer.parseInt(in.readLine());
			int[][] snail=new int[N][N];
			int x=0, y=0, now=1, turn=0;
			while(snail[x][y]==0) {
				snail[x][y]=now++;
				int change_x=x+dx[turn], change_y=y+dy[turn];
				if(change_x>=N || change_x<0 || change_y>=N || change_y<0 || 
						(change_x>=0 && change_x<N && change_y>=0 && change_y<N && 
						snail[change_x][change_y]!=0)) {
					turn=(turn+1)%4;
				}
				x+=dx[turn];
				y+=dy[turn];
				if(x>=N || x<0 || y>=N || y<0)
					break;
			}
			System.out.println("#"+(test_case+1));
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					System.out.print(snail[i][j]+" ");
				System.out.println();
			}
		}
	}
}
