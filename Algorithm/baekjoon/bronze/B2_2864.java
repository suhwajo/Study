package baekjoon.bronze;

import java.io.*;
import java.util.Arrays;

public class B2_2864 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String [] num = in.readLine().split(" ");
		int min=0, max=0;
		
		for(int i=0;i<num.length;i++) {
			String min_alph="";
			String max_alph="";
			for(int j=0;j<num[i].length();j++) {
				if(num[i].charAt(j)=='5' || num[i].charAt(j)=='6') {
					max_alph+='6';
					min_alph+='5';
				}
				else {
					max_alph+=num[i].charAt(j);
					min_alph+=num[i].charAt(j);
				}
			}
			min+=Integer.parseInt(min_alph);
			max+=Integer.parseInt(max_alph);
		}
		System.out.println(min+" "+max);
	}
}

