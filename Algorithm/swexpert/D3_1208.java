package swexpert;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1208 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#" + test_case + " ");
			int dump = Integer.parseInt(in.readLine());
			int[] box = new int[100];
			StringTokenizer str = new StringTokenizer(in.readLine()," ");
			
			for(int i=0;i<100;i++)
				box[i] = Integer.parseInt(str.nextToken());
			
			for(int i=0;i<dump;i++) {
				int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE;
				int max_num=-1, min_num=-1;
				for(int j=0;j<100;j++) {
					if(box[j]<min) {
						min=box[j];
						min_num = j;
					}
					if(box[j]>max) {
						max=box[j];
						max_num=j;
					}
				}
				box[max_num]--;
				box[min_num]++;
			}
			int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			for(int i=0;i<100;i++) {
				if(box[i]<min) {
					min=box[i];
				}
				if(box[i]>max) {
					max=box[i];
				}
			}
			sb.append(max-min+"\n");
		}
		System.out.println(sb);
	}
}
