package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;
public class S2_2961 {
	static int[] sour,bitter;
	static boolean[] isSelected;
	static int diff,N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		sour = new int[N];
		bitter = new int[N];
		diff = Integer.MAX_VALUE;
		isSelected = new boolean[N];
		for(int ingred_num=0;ingred_num<N;ingred_num++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			sour[ingred_num] = Integer.parseInt(str.nextToken());
			bitter[ingred_num] = Integer.parseInt(str.nextToken());
		}
		sour_bit(0, 1, 0);
		System.out.println(diff);
	}
	static void sour_bit(int index, int now_sour, int now_bitter) {
		if(index==N) {
			int cnt = 0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) cnt++;
			}
			if(cnt==0) return;
			int sb = Math.abs(now_bitter-now_sour);
			if(sb<diff) diff = sb;
			return;
		}
		
		isSelected[index] = true;
		sour_bit(index+1, now_sour*sour[index], now_bitter+bitter[index]);
		
		isSelected[index] = false;
		sour_bit(index+1, now_sour, now_bitter);

	}
}