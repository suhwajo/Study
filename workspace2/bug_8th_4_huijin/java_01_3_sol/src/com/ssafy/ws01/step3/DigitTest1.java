package com.ssafy.ws01.step3;

public class DigitTest1 {

	public static void main(String[] args) {
		int count = 0; //도형에 출력할 숫자 변수
		
		for(int i=0; i < 5; i++) {
			for(int j=0;j<5;j++) {
				if(j<i) { //숫자 앞쪽 공백 출력 부분
					System.out.printf("%3s"," "); //printf 를 통해 출력을 형식화할 수 있다.
				}
				else { //숫자 출력 부분
					System.out.printf("%3d",++count); //3칸 너비로 숫자 출력
				}
			}
			System.out.println();
		}
	}

}
