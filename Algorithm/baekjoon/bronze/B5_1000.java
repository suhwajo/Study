package baekjoon.bronze;

import java.io.*;
public class B5_1000 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] ab = in.readLine().split(" ");
		System.out.println(Integer.parseInt(ab[0])+Integer.parseInt(ab[1]));
	}
}
