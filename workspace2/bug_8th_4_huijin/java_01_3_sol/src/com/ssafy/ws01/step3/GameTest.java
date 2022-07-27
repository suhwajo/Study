package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		System.out.println("���������� ������ �����մϴ�. �Ʒ� ���� �� �ϳ��� ������.");
		System.out.println("1. 5�� 3��");
		System.out.println("2. 3�� 2��");
		System.out.println("3. 1�� 1��");
		
		System.out.println("��ȣ�� �Է��ϼ���.");
		
		Scanner scanner = new Scanner(System.in); //�ڵ� import. Ctrl + shift + O
		//Ctrl + 1 ���� �ڵ�����. new local variable �޴� ����
		
		int menu = scanner.nextInt();
		int loop; //�޴��� ���� ���� �ݺ� ���� ����
		
		switch(menu) {
		case 1: 
			loop=5; 
			break;
		case 2:
			loop=3;
			break;
		case 3:
			loop=1;
			break;
		default:
			System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			return;
		}
		
		int userWinCount=0; //����� �¸� Ƚ��
		int comWinCount=0; //��ǻ�� �¸�Ƚ��
		
		do {
			System.out.println("���������� �� �ϳ� �Է�: ");
			String input = scanner.next();
			int user = -1;
			
			switch(input) {
			case "����":
				user=1;
				break;
			case "����":
				user=2;
				break;
			case "��":
				user=3;
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �����ϴ�!");
				comWinCount++;
				continue;
			}
			int com = (int)(Math.random()*3)+1; // 1~3����. random -> 0.0 ~ 0.999... 
			
			boolean case1 = user==1&&com==2; //��ǻ�� ��
			boolean case2 = user==1&&com==3; //����� ��
			boolean case3 = user==2&&com==1; //����� ��
			boolean case4 = user==2&&com==3; //��ǻ�� ��
			boolean case5 = user==3&&com==1; //��ǻ�� ��
			boolean case6 = user==3&&com==2; //����� ��
			
			if(case2||case3||case6) {
				userWinCount++;
				System.out.println("�̰���ϴ�!!!");
			}
			else if(case1||case4||case5) {
				comWinCount++;
				System.out.println("�����ϴ�!!!");
			}
			else {
				System.out.println("�����ϴ�!!!");
			}
			
			if(menu==1&&userWinCount>2 || comWinCount>2) {
				break;
			}
			else if(menu==2 && userWinCount>1||comWinCount>1) {
				break;
			}
		}while(--loop!=0); //0�� �ƴҶ����� �ݺ�
		
		if(userWinCount>comWinCount) {
			System.out.println("### ���� ��!!!");
		}
		else if(userWinCount<comWinCount) {
			System.out.println("### ��ǻ�� ��!!!");
		}
		else {
			System.out.println("### ���º�!!!");
		}
	}

}
