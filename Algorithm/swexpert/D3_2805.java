package swexpert;

import java.io.*;
public class D3_2805 {
	static int[]dx = {-1,0,0};
	static int[]dy = {0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			int N = Integer.parseInt(in.readLine());
			int[][] farm = new int[N][N];
			for(int i=0;i<N;i++) {
				String str = in.readLine();
				for(int j=0;j<N;j++) {
					farm[i][j]=str.charAt(j)-'0';
				}
			}
			boolean change=true;
			int plus=0, start=(N/2)+1;
			int sum=0;
			for(int j=0;j<N;j++) {
				if(change) {
					plus=(2*j)+1;
					start--;
				}
				else{
					plus=(2*(N-j))-1;
					start++;
				}
				if(start<1) {
					change=false;
				}
				for(int i=0;i<plus;i++) {
					sum+=farm[start+i][j];
				}
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
}