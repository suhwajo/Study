package baekjoon.silver;

import java.io.*;
import java.util.*;
public class S5_1010 {
	static int[][] combi;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(str.nextToken());
		for(int test_case = 0;test_case<T;test_case++) {
			str = new StringTokenizer(in.readLine());
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			combi = new int [M+1][N+1];
			System.out.println(comb(M, N));
		}
		
	}
	public static int comb(int n, int r) {
		if(combi[n][r]!=0) return combi[n][r];
		if(n==r || r==1) {
			combi[n][r]=n-r+1;
			return	combi[n][r];
		}
		return combi[n][r] = comb(n-1,r-1)+comb(n-1,r);
	}
}