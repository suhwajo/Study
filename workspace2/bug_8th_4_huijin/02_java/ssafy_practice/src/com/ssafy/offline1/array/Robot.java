package com.ssafy.offline1.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*2차원 배열 탐색 - 로봇회사
 * S : 공백, W : 벽
 * A, B, C : 로봇
 * A : 오른쪽으로만 이동, B : 좌우로 이동, C : 상하좌우 이동
 *  */

public class Robot {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("ArrayTest_30_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine());
			int ans=0;
			char[][] arr = new char[n][n];
			//배열 입력
			for(int i=0;i<n;i++) {
				String[] str = br.readLine().split(" ");
				for(int j=0;j<n;j++)arr[i][j]=str[j].charAt(0);
			}
			
			//완전탐색
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					
					switch(arr[i][j]) {
					case 'C':
						//상
						int z=i-1;
						while(z>=0) {
							if(arr[z][j]=='S') ans+=1;
							else break;
							z--;
						}
						//하
						z=i+1;
						while(z<n) {
							if(arr[z][j]=='S') ans+=1;
							else break;
							z++;
						}
					case 'B':
						//좌
						int y=j-1;
						while(y>=0) {
							if(arr[i][y]=='S') ans+=1;
							else break;
							y--;
						}
					case 'A':
						//우
						int c=j+1;
						while(c<n) {
							if(arr[i][c]=='S') ans+=1;
							else break;
							c++;
						}
						break;
					default:
						break;
					}
					
					
				}
			}
			System.out.println("#"+test_case+" "+ans);
			
		}
		
	}

}
