package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B1_2167 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int[][] line = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			str = new StringTokenizer(in.readLine());
			for(int j=1;j<=M;j++) {
				line[i][j]=Integer.parseInt(str.nextToken())+
						line[i-1][j]+line[i][j-1]-line[i-1][j-1];
			}
		}
		int num = Integer.parseInt(in.readLine());
		for(int i=0;i<num;i++) {
			str = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(str.nextToken()),
				y1 = Integer.parseInt(str.nextToken()),
				x2 = Integer.parseInt(str.nextToken()),
				y2 = Integer.parseInt(str.nextToken());
			sb.append(line[x2][y2]-line[x1-1][y2]-line[x2][y1-1]+line[x1-1][y1-1]+"\n");
		}
		System.out.println(sb);
	}
}
