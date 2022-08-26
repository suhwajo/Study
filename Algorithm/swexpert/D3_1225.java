package swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int test_case=0;test_case<10;test_case++) {
			int T = Integer.parseInt(in.readLine());
			int minus=1;
			sb.append("#"+T+" ");
			StringTokenizer str = new StringTokenizer(in.readLine());
			Queue<Integer> que = new LinkedList<>();
			for(int i=0;i<8;i++)
				que.add(Integer.parseInt(str.nextToken()));
			
			int now;
			while(true) {
				now = que.remove();
				now-=minus;
				minus++;
				if(minus>5) minus%=5;
				if(now<1) {
					que.add(0);
					break;
				}
				que.add(now);
			}
			for(int i=0;i<8;i++)
				sb.append(que.remove()+" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}