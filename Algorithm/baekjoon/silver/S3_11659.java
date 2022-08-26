package baekjoon.silver;

import java.io.*;
import java.util.*;

public class S3_11659 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int[] line = new int[N+1];
		str = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++)
			line[i] = line[i-1]+Integer.parseInt(str.nextToken());
		
		for(int i=0;i<M;i++) {
			str = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			sb.append(line[end]-line[start-1]+"\n");
		}
		System.out.println(sb);
		
	}
}
