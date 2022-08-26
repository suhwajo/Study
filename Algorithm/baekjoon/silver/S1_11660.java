package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class S1_11660 {
	static int BEFORE = -1;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int plus[][] = new int [N+1][N+1];
		for(int i=1;i<=N;i++) {
			str=new StringTokenizer(in.readLine());
			for(int j=1;j<=N;j++) {
				plus[i][j]+=Integer.parseInt(str.nextToken())+plus[i-1][j]+plus[i][j-1]-plus[i-1][j-1];

			}
		}
		for(int test_case=0;test_case<M;test_case++) {
			str=new StringTokenizer(in.readLine());
			int[] x = new int[2];
			int[] y = new int[2];
			for(int i=0;i<2;i++) {
				x[i] = Integer.parseInt(str.nextToken());
				y[i] = Integer.parseInt(str.nextToken());
			}
			sb.append(plus[x[1]][y[1]]-plus[x[0]+BEFORE][y[1]]-plus[x[1]][y[0]+BEFORE]+plus[x[0]+BEFORE][y[0]+BEFORE]+"\n");
		}
		System.out.println(sb);
	}
}
