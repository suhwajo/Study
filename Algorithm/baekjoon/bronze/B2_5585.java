package baekjoon.bronze;
import java.io.*;
import java.util.*;
public class B2_5585 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int[] change = {500,100,50,10,5,1};
		int temp = 1000-Integer.parseInt(str.nextToken());
		int change_sum=0;
		for(int i=0;i<change.length;i++) {
			change_sum+=temp/change[i];
			temp%=change[i];
		}
		System.out.println(change_sum);
		return;
	}
}
