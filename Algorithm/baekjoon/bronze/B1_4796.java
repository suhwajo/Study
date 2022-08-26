package baekjoon.bronze;

import java.io.*;
import java.util.*;
public class B1_4796 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;
		int num=1;
		while(true) {
			str = new StringTokenizer(in.readLine());
			int L = Integer.parseInt(str.nextToken());
			int P = Integer.parseInt(str.nextToken());
			int V = Integer.parseInt(str.nextToken());
			if(L==0 &&P==0 &&V==0)
				break;
			int last = V%P;
			if(last>L) last=L;
			int day = (V/P)*L + last;
			sb.append("Case "+(num++)+": "+day+"\n");
		}
		System.out.println(sb);
	}
}
