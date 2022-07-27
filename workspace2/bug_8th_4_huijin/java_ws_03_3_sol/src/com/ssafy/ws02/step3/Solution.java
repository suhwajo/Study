package com.ssafy.ws02.step3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	//������ �ð���� 8����
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt")); //�������� �־��� Input ������ ���ϸ� �ۼ�
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine()); //�׽�Ʈ���̽� �Է�
		
		for(int test_case=1;test_case<=T;test_case++) {
			int N = Integer.parseInt(in.readLine()); //������ �� �� ����
			char[][] map = new char[N][N]; //���� ������ ���� 2���� �迭
			
			for(int i=0;i<N;i++) {
				String[] split = in.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j] = split[j].charAt(0);
				}
			}
			
			int max=0; // ���� ���� ���� �� �ִ� ���� ������ �����ϴ� ����
			
			//2���� �迭 ����Ž��
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					int flag=0; //������ �����ϸ� 1
					
					//�� ��ġ���� �ֺ� 8�� Ž���Ͽ� ������ �ִ��� ���� Ȯ��
					for(int i=0;i<8;i++) {
						int testX=x+dx[i];
						int testY=y+dy[i];
						
						if(0<= testX && testX<N && 0<=testY && testY<N) {
							//�ֺ��� ������ �ִٸ� Ž�� �ߴ�
							if(map[testX][testY]=='G') {
								flag=1;
								break;
							}
							
						}
					}
					
					if(flag==1) { //���� ��ȹ�� ������ �����ϸ� 2��
						if(max<2)max=2;
					}
					else if(flag==0) { //���� ��ȹ�� ������ ���� ���, ���� ���� Ž��
						int cnt=0;
						for(int i=0;i<N;i++) {
							if(map[x][i]=='B')cnt++; //���κ��� ��
							if(map[i][y]=='B')cnt++; //���κ��� ��
						}
						
						cnt--; //���ڽ� �ߺ��ϳ� ����
						
						if(max<cnt)max=cnt;
					}
				}
			}
			
			
			System.out.println("#"+test_case+" "+max);
		}
	}

}
