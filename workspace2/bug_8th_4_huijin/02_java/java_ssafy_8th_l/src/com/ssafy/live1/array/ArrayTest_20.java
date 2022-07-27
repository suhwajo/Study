package com.ssafy.live1.array;


public class ArrayTest_20 {
	public static void main(String[] args) {

		char[][] grid = { 
		        { '2', '3', '1', '4' }, 
		        { '1', 'X', '3', '2' }, 
		        { '3', '4', 'X', 'X' },
				{ 'X', '4', '1', '5' } };

		int sum = 0;
		
		int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
		
		// TODO: X로 표시된 항목의 상좌우 숫자의 합을 구하시오.
		//  단 합을 구할 때 이미 더한 영역은 다시 더하지 않는다.
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(grid[i][j]!='X') {

					for(int z=0;z<4;z++) {
						int nx= i + dir[z][0];
						int ny= j + dir[z][1];
						if(nx>=0&&nx<4 &&ny>=0&&ny<4) {
							if(grid[nx][ny]=='X') {
								sum+=grid[i][j]-'0';
								break;
							}
						}
						
					}
					
				}
			}
		}
		// END:
		System.out.println(sum);
	}
}
