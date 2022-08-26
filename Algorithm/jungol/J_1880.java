package jungol;

import java.io.*;
import java.util.*;

public class J_1880 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = in.readLine();
		char small[] = new char[26], large[] = new char[26];
		for(int i=0;i<26;i++) {
			small[i] = line.charAt(i);
			large[i] = (char) (line.charAt(i)-'a'+'A');
		}
		line = in.readLine();
		for(int i=0;i<line.length();i++) {
			char now = line.charAt(i);
			if(now==' ') sb.append(" ");
			else if(now>='A' &&now<='Z') sb.append(large[now-'A']);
			else sb.append(small[now-'a']);
		}
		System.out.println(sb);
	}

}
