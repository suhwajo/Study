package swexpert;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_1210 {
	static int[]dx = {-1,0,0};
	static int[]dy = {0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#" + test_case + " ");
			int T = Integer.parseInt(in.readLine());
			int[][] ladder = new int[100][100];
			for(int i=0;i<100;i++) {
				StringTokenizer str = new StringTokenizer(in.readLine());
				for(int j=0;j<100;j++)
					ladder[i][j] = Integer.parseInt(str.nextToken());
			}
			for(int i=0;i<100;i++) {
				int dir_x=dx[0], dir_y=dy[0];
				if(ladder[99][i]!=2) continue;
				int x=99, y=i, dir = 0; //dir 0위 1오 2왼

				while(x>=0) {
					if((y+dy[1])<100 && ladder[x][y+dy[1]] == 1 && dir!=2) {
						dir=1;
						dir_x = dx[1];
						dir_y = dy[1];
						y+=dy[1];
					} else if((y+dy[2])>=0 && ladder[x][y+dy[2]] == 1 && dir!=1) {
						dir=2;
						dir_x = dx[2];
						dir_y = dy[2];
						y+=dy[2];
					} else{
						dir=0;
						dir_x = dx[0];
						dir_y = dy[0];
						x+=dx[0];
					}
				}
				sb.append(y+"\n");
			}
		}
		System.out.println(sb);
	}
}
