package baekjoon.bronze;
import java.util.*;
import java.io.*;
public class B1_1032 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		String line = in.readLine();
		int size = line.length();
		char[] pattern = new char[size];
		for(int i=0;i<size;i++) pattern[i] = line.charAt(i);
		for(int i=1;i<T;i++) {
			line = in.readLine();
			for(int j=0;j<size;j++) {
				if(line.charAt(j)!=pattern[j]) pattern[j]='?';
			}
		}
		for(int i=0;i<size;i++) sb.append(pattern[i]);
		System.out.println(sb);

	}

}
