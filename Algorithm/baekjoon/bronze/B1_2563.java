package baekjoon.bronze;

import java.io.*;
import java.util.*;
public class B1_2563 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		boolean [][] paper = new boolean[100][100];
		int sum = 0;
		for(int i = 0; i<T;i++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(str.nextToken());
			int y1 = Integer.parseInt(str.nextToken());
			for(int x=x1;x<x1+10;x++) {
				for(int y=y1;y<y1+10;y++) {
					paper[x][y]=true;
				}
			}
		}
		for(int i=0;i<100;i++) 
			for(int j=0;j<100;j++)
				if(paper[i][j]) sum++;
		System.out.println(sum);
	}
}