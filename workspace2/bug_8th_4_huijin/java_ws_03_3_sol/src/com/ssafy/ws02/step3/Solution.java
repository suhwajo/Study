package com.ssafy.ws02.step3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	//위부터 시계방향 8방향
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt")); //문제에서 주어진 Input 데이터 파일명 작성
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine()); //테스트케이스 입력
		
		for(int test_case=1;test_case<=T;test_case++) {
			int N = Integer.parseInt(in.readLine()); //부지의 한 변 길이
			char[][] map = new char[N][N]; //부지 정보를 담을 2차원 배열
			
			for(int i=0;i<N;i++) {
				String[] split = in.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j] = split[j].charAt(0);
				}
			}
			
			int max=0; // 가장 높이 세울 수 있는 빌딩 층수를 저장하는 변수
			
			//2차원 배열 완전탐색
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					int flag=0; //공원이 존재하면 1
					
					//현 위치에서 주변 8방 탐색하여 공원이 있는지 여부 확인
					for(int i=0;i<8;i++) {
						int testX=x+dx[i];
						int testY=y+dy[i];
						
						if(0<= testX && testX<N && 0<=testY && testY<N) {
							//주변에 공원이 있다면 탐색 중단
							if(map[testX][testY]=='G') {
								flag=1;
								break;
							}
							
						}
					}
					
					if(flag==1) { //인접 구획에 공원이 존재하면 2층
						if(max<2)max=2;
					}
					else if(flag==0) { //인접 구획에 공원이 없을 경우, 가로 세로 탐색
						int cnt=0;
						for(int i=0;i<N;i++) {
							if(map[x][i]=='B')cnt++; //가로빌딩 합
							if(map[i][y]=='B')cnt++; //세로빌딩 합
						}
						
						cnt--; //나자신 중복하나 빼기
						
						if(max<cnt)max=cnt;
					}
				}
			}
			
			
			System.out.println("#"+test_case+" "+max);
		}
	}

}
