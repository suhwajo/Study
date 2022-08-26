package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class B3_11034 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11034.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		while((str=in.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(str);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int max = Math.max((B-A), (C-B))-1;
			sb.append(max+"\n");
		}
		System.out.println(sb);
	}

}
