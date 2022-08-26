package baekjoon.silver;

import java.io.*;
import java.util.Stack;
public class S4_4949 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while(!((str=in.readLine()).equals("."))) {
			boolean yn = true;
			Stack<Character> large = new Stack<>();
			for(int i=0;i<str.length();i++) {
				char now = str.charAt(i);
				if((now==')' && large.empty()) || (now==']' && large.empty())) {
					yn=!yn;
					break;
				}
				if(now=='(' || now=='[') large.push(now);
				else if(now==')' || now==']') {
					char pop = large.pop();
					if(now==']' && pop=='(' || now==')' && pop=='[') {
						yn=!yn;
						break;
					}
				}
			}
			if(yn && large.empty()) System.out.println("yes");
			else System.out.println("no");
		}
	}
}