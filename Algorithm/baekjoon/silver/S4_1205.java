package baekjoon.silver;

import java.io.*;
import java.util.*;
public class S4_1205 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken());
		int new_score = Integer.parseInt(str.nextToken());
		int P = Integer.parseInt(str.nextToken());
		List<Integer> score = new ArrayList<Integer>();
		if(N!=0) str = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) score.add(Integer.parseInt(str.nextToken()));
		score.add(new_score);
		Collections.sort(score, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		if(score.size()>10 && new_score<=score.get(P)) {
			System.out.println(-1);
			return;

		}
			
		for(int i=0;i<P;i++) {
			if(score.get(i)==new_score) {
				System.out.println(i+1);
				return;
			}
		}
	}
}
