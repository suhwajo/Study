package swexpert;

import java.io.*;
class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String num = in.readLine();
			boolean zero = true;
			int count = 0;
			
			for(int i=0;i<num.length();i++) {
				if(num.charAt(i)=='1' && zero) {
					count++;
					zero = !zero;
				} else if(num.charAt(i)=='0' && !zero) {
					count++;
					zero = !zero;
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
}