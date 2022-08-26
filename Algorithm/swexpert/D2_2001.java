package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_2001 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case=0;test_case<T;test_case++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			int[][] map = new int[N+1][N+1];
			for(int i=1;i<N+1;i++) {
				str = new StringTokenizer(in.readLine());
				for(int j=1;j<N+1;j++)
					map[i][j] = Integer.parseInt(str.nextToken())+map[i-1][j]+map[i][j-1]-map[i-1][j-1];
			}
			int max = 0;
			for(int i=M;i<=N;i++) {
				for(int j=M;j<=N;j++) {
					int now = map[i][j]-map[i-M][j]-map[i][j-M]+map[i-M][j-M];
					if(now>max)
						max=now;
				}
			}
			System.out.println("#"+(test_case+1)+" "+max);
		}
	}
}