package baekjoon.silver;

import java.io.*;
import java.util.*;

public class S4_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer str = new StringTokenizer(in.readLine());
		int[] people = new int[N];
		for(int i=0;i<N;i++)
			people[i] = Integer.parseInt(str.nextToken());
		Arrays.sort(people);
		int time = 0;
		for(int i=N;i>0;i--) {
			time+=(people[N-i]*i);
		}
		System.out.println(time);
	}

}
