package com.ssafy.ws01.step3;

public class DigitTest1 {

	public static void main(String[] args) {
		int count = 0; //������ ����� ���� ����
		
		for(int i=0; i < 5; i++) {
			for(int j=0;j<5;j++) {
				if(j<i) { //���� ���� ���� ��� �κ�
					System.out.printf("%3s"," "); //printf �� ���� ����� ����ȭ�� �� �ִ�.
				}
				else { //���� ��� �κ�
					System.out.printf("%3d",++count); //3ĭ �ʺ�� ���� ���
				}
			}
			System.out.println();
		}
	}

}
