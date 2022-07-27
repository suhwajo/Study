package com.ssafy.offline2.array;

public class ZigZag {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9}};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
		
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			for(int j=arr[i].length-1;j>=0;j--) {
				System.out.print(arr[i][j]+" ");
			}
		}
		
		System.out.println();

		//지그재그 출력
		//i 짝수 : 순방향, 홀수 : 역방향
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(i%2==0)System.out.print(arr[i][j]+" ");
					
				else System.out.print(arr[i][arr[i].length-1-j]+" ");
				
			}
		}
		
		//아래로 출력하는것도 해보자
	}

}
