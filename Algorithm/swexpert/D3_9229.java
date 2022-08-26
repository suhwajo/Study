package swexpert;

import java.io.*;
import java.util.*;
public class D3_9229 {
	static int N, M, cnt;
	static int[] snack_weight, two_snack;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 1; test_case<=T;test_case++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			int comb_num = (N*(N-1))/2, max=-1;
			snack_weight = new int[N];
			two_snack = new int[comb_num];
			str = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)
				snack_weight[i] = Integer.parseInt(str.nextToken());
			cnt = 0;
			comb(0,0,0);
			
			for(int i=0;i<comb_num;i++) {
				if(two_snack[i]>max && two_snack[i]<=M)
					max = two_snack[i];
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
	public static void comb(int n, int start, int now_weight) {
		if(n==2) {
			two_snack[cnt] = now_weight;
			cnt++;
			return;
		}
		for(int i=start;i<N;i++) {
			comb(n+1, i+1, now_weight+snack_weight[i]);
		}
	}
}