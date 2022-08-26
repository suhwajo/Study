package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class D1_2071 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = in.nextInt();
//		int T = Integer.parseInt(bf.readLine());
		for(int test_case = 0;test_case<T;test_case++) {
			int sum=0;
			for(int i=0;i<10;i++)
				sum += in.nextInt();
			System.out.println("#"+(test_case+1)+" "+Math.round(sum/10.0));
		}
	}
}
