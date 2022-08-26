package baekjoon.gold;

import java.io.*;
import java.util.*;
public class G5_13023 {
	static boolean check[], yn;
	static List<Integer>[] relation;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken()); // 사람
		int M = Integer.parseInt(str.nextToken()); // 관계
		relation = new ArrayList[N];
		for(int i=0;i<N;i++) relation[i] = new ArrayList<Integer>();
		for(int i=0;i<M;i++) {
			str = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(str.nextToken());
			int to = Integer.parseInt(str.nextToken());
			relation[from].add(to);
			relation[to].add(from);
		}

		for(int i=0;i<N;i++) {
			check = new boolean[N];
			dfs(i, 0);
			if(yn) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	public static void dfs(int cur, int depth) {
		if(yn || depth==4) {
			yn=true;
			return;			
		}
		check[cur] = true;
		
		for (int i=0, size = relation[cur].size();i<size;i++) {
			if(!check[relation[cur].get(i)]) { // 방문하지 않았으며 인접한 경우
				dfs(relation[cur].get(i), depth+1);
			}
		}
		check[cur] = false;
	}
}