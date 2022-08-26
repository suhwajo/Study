package swexpert;

import java.io.*;
import java.util.*;
public class D_5644 {
	static int[] dx = {0,-1, 0, 1, 0}, dy = {0, 0, 1, 0, -1};
	static public class BC{
		public int x, y, c, p;
		public BC(int y, int x, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer str1 = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(str1.nextToken());
			int BCnum = Integer.parseInt(str1.nextToken());
			int[] userA = new int[M+1], userB = new int[M+1];
			str1 = new StringTokenizer(in.readLine());
			StringTokenizer str2 = new StringTokenizer(in.readLine());
			
			for(int i=1;i<=M;i++) {
				userA[i] =Integer.parseInt(str1.nextToken());
				userB[i] =Integer.parseInt(str2.nextToken());
			}
			userA[0]=0;
			userB[0]=0;
			BC[] BCinfo = new BC[BCnum];
			for(int i=0;i<BCnum;i++) {
				str1 = new StringTokenizer(in.readLine());
				BCinfo[i] = new BC(Integer.parseInt(str1.nextToken()), Integer.parseInt(str1.nextToken()), 
						Integer.parseInt(str1.nextToken()), Integer.parseInt(str1.nextToken()));
			}
			int charge=0;
			int userAx=1, userAy=1, userBx=10, userBy=10;
			for(int i=0;i<=M;i++) {
				userAx+=dx[userA[i]];
				userAy+=dy[userA[i]];
				userBx+=dx[userB[i]];
				userBy+=dy[userB[i]];
				
				int max=0;
				for(int A=0;A<BCnum;A++) {//사용자 A
					for(int B=0;B<BCnum;B++) { // 사용자 B
						int P_A=0, P_B=0;
						BC tempA=null, tempB = null;
						if(((int)Math.abs(userAx-BCinfo[A].x)+(int)Math.abs(userAy-BCinfo[A].y))<=BCinfo[A].c) {
							tempA=BCinfo[A];
							P_A=tempA.p;
						}
						if(((int)Math.abs(userBx-BCinfo[B].x)+(int)Math.abs(userBy-BCinfo[B].y))<=BCinfo[B].c) {
							tempB=BCinfo[B];
							P_B=tempB.p;
						}
						if(tempA!=tempB)
							max = Math.max(max, P_A+P_B);
						else if(tempA!=null && tempA==tempB)
							max = Math.max(max, P_B);
					}
				}
				charge+=max;
			}
			sb.append("#"+test_case+" "+charge+"\n");
		}
		System.out.println(sb);
	}
}