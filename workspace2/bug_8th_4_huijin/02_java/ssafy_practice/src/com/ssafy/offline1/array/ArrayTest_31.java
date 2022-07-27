package com.ssafy.offline1.array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayTest_31 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("ArrayTest_31_input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			int n = sc.nextInt();
			int num = sc.nextInt();
			boolean[][] chk=new boolean[n][n]; //소금쟁이가 뛴 자리 표시
			int[][] map = new int[num][3];
			int ans=0;
			
			//우선 입력을 먼저 다 받고
			for(int i=0;i<num;i++) {
				map[i][0]=sc.nextInt();
				map[i][1]=sc.nextInt();
				map[i][2]=sc.nextInt();
			}
			
			label1:
			for(int i=0;i<num;i++) {
				int x = map[i][0];
				int y = map[i][1];
				int dir = map[i][2];
				
				//*주의: 시작할때부터 위치를 확인해줘야 한다!!
				if(chk[x][y]) {
					ans=i+1;
					break;
				}
				else chk[x][y]=true;
				
				for(int j=3;j>0;j--) {//3, 2, 1 점프 
					
					if(dir==1) x+=j; //하
					else if(dir==2) y+=j; //우
					
					if(x>=n || y>=n) {
						break; //범위 벗어나면 종료
					}

					if(chk[x][y]==true) { //점프하는 위치가 이미 체크되어있으면 종료
						ans=i+1;
						break label1; //탐색을 끝내야 하므로 label을 통해 앞앞의 for문을 종료하도록 해준다.
					}
					else chk[x][y]=true; //체크되어있지 않으면 체크해주기
				}
				
			}
			System.out.println("#"+test_case+" "+ans);
			
			
		}
	}

}
