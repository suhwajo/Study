package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
public class D4_1218 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10;i++) {
			String n = in.readLine();
			boolean yn = true;
			String line = in.readLine();
			Stack<Character> stack = new Stack<>();
			for(int j=0;j<line.length();j++) {
				char now = line.charAt(j);
				if(now=='(' || now=='[' || now=='{' || now=='<') {
					stack.push(now);
				} else {
					char pop = stack.pop();
					if((pop=='(' && now!=')') || 
						(pop=='[' && now!=']') || 
						(pop=='<' && now!='>') ||
						(pop=='{' && now!='}')) {
						yn=!yn;
						break;
					}
				}
			}
			if(!yn || !(stack.empty()))
				sb.append("#"+(i+1)+" "+0+"\n");
			else sb.append("#"+(i+1)+" "+1+"\n");
		}
		System.out.println(sb);
	}
}