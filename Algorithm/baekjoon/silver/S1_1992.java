package baekjoon.silver;

import java.io.*;
import java.util.*;
public class S1_1992 {
	static int N;
	static int[][] map;
	static Queue<String> queue;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String str = in.readLine();
			for(int j=0;j<N;j++) map[i][j] = str.charAt(j)-'0';
		}
		queue = new LinkedList<String>();
		cut(0,0,N);
		while(!queue.isEmpty())
			sb.append(queue.poll());
		System.out.println(sb);
	}
	private static void cut(int r, int c, int size) {
		int sum=0;
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) sum+=map[i][j];
		}
		if(sum==size*size) queue.add("1");
		else if(sum==0) queue.add("0");
		else {
			queue.add("(");
			int half = size/2;
			cut(r, c, half);
			cut(r,c+half,half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			queue.add(")");
		}
	}
}