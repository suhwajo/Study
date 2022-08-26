package swexpert;

import java.io.*;
import java.util.*;
public class D4_3234 {
	static int perm_cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(in.readLine()), weight[] = new int[N];
			StringTokenizer str = new StringTokenizer(in.readLine());
			
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(str.nextToken());
			}
			perm_cnt=0;
			boolean[] isSelected = new boolean[N];
			perm(N, weight, isSelected, 0,0,0);
			System.out.println("#"+test_case+" "+perm_cnt);
		}
	}
	private static void perm(int N, int[] weight,boolean[] isSelected, int cnt, int left_sum, int right_sum) {
		if(left_sum<right_sum) return;
		if(cnt==N) {
			perm_cnt++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			isSelected[i]=true;
			perm(N, weight, isSelected,cnt+1,left_sum+weight[i], right_sum);
			perm(N, weight, isSelected,cnt+1,left_sum, right_sum+weight[i]);
			isSelected[i]= false;
		}
	}
}