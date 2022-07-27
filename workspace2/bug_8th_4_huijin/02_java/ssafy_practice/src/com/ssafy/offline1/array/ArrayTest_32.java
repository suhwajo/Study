package com.ssafy.offline1.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayTest_32 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("ArrayTest_32_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int T = Integer.parseInt(br.readLine());
		int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
		
		for(int t=1;t<=T;t++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int x = Integer.parseInt(str[1]);
			int y = Integer.parseInt(str[2]);
			int jumper = Integer.parseInt(str[3]);
			int[][] map = new int[n+1][n+1];
			
			stk = new StringTokenizer(br.readLine());
			
			//점퍼 좌표 1로 체크
			for(int i=0;i<jumper;i++) {
				map[Integer.parseInt(stk.nextToken())][Integer.parseInt(stk.nextToken())] = 1;
			}
			
			//이동지시 개수
			int m_n= Integer.parseInt(br.readLine()); 
			int[][] move = new int[m_n][2];
			stk = new StringTokenizer(br.readLine());
			
			// 1 : 상 , 2 : 우 , 3: 하, 4: 좌
			for(int i=0;i<m_n;i++) {
				move[i][0]=Integer.parseInt(stk.nextToken()); //방향
				move[i][1]=Integer.parseInt(stk.nextToken()); //이동칸수
			}
			
			//이동 시작
			
			//System.out.println(x+" "+y);
			label1:
			for(int i=0;i<m_n;i++) {
				int a = move[i][0]; //방향
				
				//이동칸수 만큼 이동. for문을 통해 점퍼에 부딪히는지 확인한다.
				for(int j=0;j<move[i][1];j++) {
					x += dir[a-1][0];
					y += dir[a-1][1];
					
					if((x<=0||x>n||y<=0||y>n)||map[x][y]==1) {
						x=0;
						y=0;
						break label1;
					}
				}
				//System.out.println(x+" "+y);
			}
			System.out.printf("#%d %d %d\n",t,x,y);
		}
	}
}
