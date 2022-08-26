package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class B1_1357 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int[] num = new int[2];
		
		for(int i=0;i<2;i++) {
			String now = str.nextToken();
			for(int j=now.length()-1;j>=0;j--)
				num[i]=num[i]*10+(now.charAt(j)-'0');
		}
		
		int rev = num[0]+num[1];
		int result = 0;

		while(rev!=0) {
			result = result*10+(rev%10);
			rev/=10;
		}
		System.out.println(result);
	}

}
