package com.ssafy.ws01.step3;

public class DigitTest2 {

	public static void main(String[] args) {
		int target = 5/2; //����� �����Ǵ� ��ǥ���� ����
		int blank = 0; //���� ��� ī��Ʈ ����
		boolean isIncrease = true; // ���� ���� ���� ����
		int no = 1; //��� ���� ����
		
		//������ ���ڱ��� ��� �ݺ�
		while(no<=17) { 
			
			//���� ���� ���� ��� �κ�
			for(int j=0;j<blank;j++) {
				//3ĭ�� �ʺ�� ���� ���
				System.out.printf("%3s"," ");
			}
			
			//���� ��� �κ�
			for(int j=0;j<5 - 2*blank;j++) {
				//3ĭ�� �ʺ�� ���� ���
				System.out.printf("%3s", no++);
			}
			System.out.println();
			
			//���� ���� ����̸� ī��Ʈ ���� �ƴϸ� ī��Ʈ ���� ó��
			if(isIncrease) {
				++blank;
			}
			else {
				--blank;
			}
			if(blank==target) {
				//���� ī��Ʈ�� ������ �Ǵ� ��ǥ������ ��ġ�ϸ� ���� ���ҿ��η� ����
				isIncrease=false;
			}
		}
	}

}
