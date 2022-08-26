package baekjoon.bronze;

import java.io.*;
public class B2_3040 {
	static int[] small, real_small, small_pre;
	static int sum;
	static boolean yn;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		small = new int[10];
		real_small = new int[7];
		small_pre = new int[7];
		for(int i=0;i<9;i++) {
			small[i] = Integer.parseInt(in.readLine());
		}
		comb(0, 0);
		for(int i=0;i<7;i++)
			System.out.println(real_small[i]);
	}
	
	public static void comb(int cnt, int start) {
		if(yn || cnt==7) {
			if(sum==100) {
				yn=true;
				for(int i=0;i<7;i++)
					real_small[i] = small_pre[i];
			}
			return;
		}
		for(int i=start;i<9;i++) {
			small_pre[cnt]=small[i];
			sum+=small[i];
			comb(cnt+1, i+1);
			sum-=small[i];
		}
	}
}