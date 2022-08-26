package baekjoon.silver;

import java.io.*;
import java.util.*;

public class S1_1991 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int
		HashMap<String, Integer> alph = new HashMap<>();
		StringTokenizer str = new StringTokenizer(in.readLine());
		String mom = str.nextToken();
		String child1 = str.nextToken();
		String child2 = str.nextToken();
		alph.put(mom, 1);
		alph.put(child1, 2);
		alph.put(child2, 3);


		for(int i=0;i<N;i++) {
			str = new StringTokenizer(in.readLine());
			int now = alph.get(str.nextToken());
			
		}
		

	}

}
