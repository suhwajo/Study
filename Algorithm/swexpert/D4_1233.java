package swexpert;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class D4_1233 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1;test_case<=10;test_case++) {
			sb.append("#"+test_case+" ");
			StringTokenizer str = new StringTokenizer(in.readLine());
			int tree_num = Integer.parseInt(str.nextToken());
			boolean yn = true;
			for(int i=0;i<tree_num;i++) {
				str = new StringTokenizer(in.readLine());
				str.nextToken();
				char now = str.nextToken().charAt(0);
				if((str.hasMoreTokens() && now>='0' && now <= '9') ||
						(!str.hasMoreTokens() && now<'0' && now>'9')) {
					yn=false;
				}
			}
			if(yn) sb.append(1+"\n");
			else sb.append(0+"\n");
		}
		System.out.println(sb);
	}
}