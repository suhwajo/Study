package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_10828 {
	static int MAX_SIZE=10000;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] stack = new int[10000];
		int now=-1;
		for(int i=0;i<T;i++) {
			String[] recommend = in.readLine().split(" ");
			switch(recommend[0]) {
			case "push":
				stack[++now]=Integer.parseInt(recommend[1]);
				break;
			case "pop":
				if(now==-1) {
					System.out.println(-1);
					break;
				}
				System.out.println(stack[now]);
				stack[now--]=0;
				break;
			case "size":
				System.out.println(now+1);
				break;
			case "empty":
				if(now==-1) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if(now==-1) {
					System.out.println(-1);
					break;
				}
				System.out.println(stack[now]);
				break;
			}
				
		}
	}

}
