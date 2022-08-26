package swexpert;

import java.io.*;
import java.util.*;
public class D3_5215 {
	static int max_cal, max_point, N;
	static boolean[] isSelected;
	static int[] cal, point;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			N = Integer.parseInt(str.nextToken());
			max_cal = Integer.parseInt(str.nextToken());
			max_point = 0;
			cal = new int[N];
			point = new int[N];
			isSelected = new boolean[N];
			
			for(int ingred_num=0;ingred_num<N;ingred_num++) {
				str = new StringTokenizer(in.readLine());
				point[ingred_num] = Integer.parseInt(str.nextToken());
				cal[ingred_num] = Integer.parseInt(str.nextToken());
			}
			subset(0, 0, 0);
			sb.append("#"+test_case+" "+max_point+"\n");
		}
		System.out.println(sb);
	}
	
	private static void subset(int index, int now_cal, int now_point) {
		if(index==N || max_cal<now_cal) {
			int point_subset = now_point;
			if(max_cal<now_cal) point_subset -= point[index-1];
			if(max_point<point_subset) max_point=point_subset;
			return;
		}
		
		isSelected[index] = true;
		subset(index+1, now_cal+cal[index], now_point+point[index]);
		
		isSelected[index] = false;
		subset(index+1, now_cal, now_point);
		
	}
}