package com.ssafy.offline2.readline;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//ctrl shift O : 자동 import

public class ReadLine {
	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("ArrayTest_30_input.txt"));  // 문제에서 주어진 Input 데이터 파일명 작성
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        System.out.println(line);
        
        int a = Integer.parseInt(line); //parseInt : static 으로 작성된 method. 바로 호출 가능
        
        int b = Integer.parseInt(in.readLine());
        
        String readLine2 = in.readLine();
        System.out.println(readLine2);
        
        
        String[] s = readLine2.split(" ");
        System.out.println(s[0]);
        char c = s[0].charAt(0);
        System.out.println(c);
        
        System.setIn(new FileInputStream("ArrayTest_31_input.txt"));
        in = new BufferedReader(new InputStreamReader(System.in));
        
        String a1= in.readLine();
        int i1=Integer.parseInt(a1);
        
        String[] s1 = in.readLine().split(" ");
        String s2=s1[0];
        int a2 = Integer.parseInt(s2);
        System.out.println(a2);
        System.out.println(in.readLine());
        
        String[] sp = in.readLine().split(" ");
        int c1 = Integer.parseInt(sp[0]);
        int c2 = Integer.parseInt(sp[1]);
        int c3 = Integer.parseInt(sp[2]);
        
        System.out.println(c1+" "+c2+" "+c3);

	}
}
