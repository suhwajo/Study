package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G5_1759 {
	static int C, L;
	static String combi_str[], string[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		sb = new StringBuilder();
		L = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		combi_str = new String[L];
		string = in.readLine().split(" ");
		Arrays.sort(string);
		check(0, 0);
		System.out.println(sb);
	}
	public static void check(int cnt, int start) {
		String aeiou[] = {"a","e","i","o","u"};
		if(cnt==L) {
			int aei = 0, not_aei = 0;
			for(int i=0, size = combi_str.length;i<size;i++) {
				for(int j=0;j<5;j++) {
					if(combi_str[i].equals(aeiou[j])) aei++;
				}
			}
			not_aei = combi_str.length-aei;
			if(aei>0 && not_aei>1) {
				for(int i=0, size = combi_str.length;i<size;i++) sb.append(combi_str[i]);
				sb.append("\n");
			} return;
		}
		for(int i=start; i<C;i++) {
			combi_str[cnt] = string[i];
			check(cnt+1, i+1);
		}
	}
}