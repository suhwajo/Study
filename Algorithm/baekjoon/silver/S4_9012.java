package baekjoon.silver;

import java.io.*;
import java.util.Stack;
public class S4_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int i=0;i<T;i++) {
			Stack<String> stack = new Stack<>();
			String line = in.readLine();
			boolean yn = true;
			for(int j=0;j<line.length();j++) {
				char now = line.charAt(j);
				if(stack.empty() && now==')') {
					yn=!yn;
					break;
				}
				if(now=='(')
					stack.push(Character.toString(line.charAt(j)));
				else stack.pop();
			}
			if(yn && stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
