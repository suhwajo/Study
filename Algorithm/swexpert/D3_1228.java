package swexpert;

import java.io.*;
import java.util.*;
public class D3_1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case<=10; test_case++) {
			List<Integer> password = new LinkedList<>();
			int N = Integer.parseInt(in.readLine());
			StringTokenizer str = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)
				password.add(Integer.parseInt(str.nextToken()));
			
			int recom = Integer.parseInt(in.readLine());
			str = new StringTokenizer(in.readLine());
			for(int i=0;i<recom;i++) {
				if(str.nextToken().equals("I")) {
					int place = Integer.parseInt(str.nextToken());
					int new_password_num = Integer.parseInt(str.nextToken());
					
					for(int j=0;j<new_password_num;j++) {
						password.add(place+j, Integer.parseInt(str.nextToken()));
					}
				}
			}
			sb.append("#"+test_case+" ");
			for(int i=0;i<10;i++) {
				sb.append(password.get(i)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}