package baekjoon.silver;

import java.io.*;
import java.util.*;

public class S4_2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int five = N/5, three;
		for(int i=five;i>-1;i--) {
			int now = N-(i*5);
			if(now%3==0) {
				System.out.println(i+(now/3));
				return;
			}
		}
		System.out.println(-1);
		return;
	}
}
