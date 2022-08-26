package swexpert;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class D2_1970 {

	public static void main(String args[]) throws Exception{
		Scanner in = new Scanner(System.in);	

		int T = in.nextInt();
		System.out.println(T);
		int[] change = {50000, 10000, 5000, 1000, 500, 100,50, 10};
		int[] change_num = new int[8];
		for(int test_case = 0;test_case<T;test_case++) {
			int money = in.nextInt();
			for(int i=0;i<change.length;i++) {
				change_num[i]=money/change[i];
				money -= change[i]*change_num[i];
			}
			System.out.println("#"+(test_case+1));
			for(int i=0;i<change_num.length;i++) {
				System.out.print(change_num[i]+" ");
			}
			System.out.println();
		}
	}
}
//	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input_1970.txt"));
//		
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine());
//		int[] change = {50000, 10000, 5000, 1000, 500, 100,50, 10};
//		int[] change_num = new int[8];
//		for(int test_case = 0;test_case<T;test_case++) {
//			int money = Integer.parseInt(in.readLine());
//			for(int i=0;i<change.length;i++) {
//				change_num[i]=money/change[i];
//				money -= change[i]*change_num[i];
//			}
//			System.out.println("#1");
//			for(int i=0;i<change_num.length;i++) {
//				System.out.println(Arrays.toString(change_num));
//			}
//		}
//		
//	}

//}