package baekjoon.bronze;

import java.io.*;
import java.util.*;
public class B3_20361 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken());
		int X = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		for(int i=0;i<K;i++) {
			String[] line = in.readLine().split(" ");
			int first = Integer.parseInt(line[0]);
			int second = Integer.parseInt(line[1]);
			if (first==X) X = second;
			else if(second==X) X = first;
		}
		System.out.println(X);
	}
}