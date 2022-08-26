package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class B2_2954 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력을 위해 StringBuilder사용
		char[] aeiou = {'a','e','i','o','u'}; // a,e,i,o,u가 들어있는지 비교를 위해 char형 배열로 저장
		String line = in.readLine(); // 암호문 read
		int now = 0; // line길이의 첫번째 알파벳부터 체크하기 위해 now를 0으로 지정하고 시작
		while(now<line.length()) { // now가 line의 길이보다 작을동안 돌도록 while문 조건 지정
			char now_char = line.charAt(now); // now 위치에서의 line의 char읽어옴
			sb.append(now_char); // now_char을 string builder에 append
			for(int i=0;i<5;i++) { // aeiou길이 만큼 반복
				if(now_char==aeiou[i]) { // 현재 알파벳이 aeiou와 같으면 p와 모음 하나 총 2개의 char를 건너뜀
					now+=2;
				}
			}
			now+=1; // 현재 위치에서 다음 char을 읽기 위해 now를 1 증가시킴
		}
		System.out.println(sb); // 올바른 문장 출력
	}
}
