package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1_1259 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while(!(str=in.readLine()).equals("0")) {
			int len = str.length()/2;
			boolean yn = true;
			for(int i=0;i<=str.length()/2;i++) {
				if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
					yn=!yn;
					break;
				}
			}
			if(yn) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
