package baekjoon.gold;

import java.io.*;
import java.util.*;

public class G5_15686 {
	static int N, M, chic_count;
	static int[] numbers;
	static int[][] map;
	static List<Integer[]> chicken_house, house, chicken_open;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		house = new ArrayList<>();
		chicken_house = new ArrayList<>();
		chicken_open = new ArrayList<>();
		chic_count = 0;
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		numbers = new int[M];

		map = new int[N][N];
		for(int i=0;i<N;i++) {
			str = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if(map[i][j]==1) {
					house.add(new Integer[]{i,j});
				}else if(map[i][j]==2) {
					chicken_house.add(new Integer[]{i,j});
				}
			}
		}
		comb(0,0);
		int[] chicken_load =new int[chicken_open.size()]; 
		for(int i=0;i<chicken_open.size();i++) {
			int sum=0;
			for(int j=0;j<house.size();j++) {
				int min = Math.abs(chicken_house.get(chicken_open.get(i)[0])[0]-house.get(j)[0])+
						Math.abs(chicken_house.get(chicken_open.get(i)[0])[1]-house.get(j)[1]);
				for(int diff=1;diff<M;diff++) {
					min = Math.min(min, 
							Math.abs(chicken_house.get(chicken_open.get(i)[diff])[0]-house.get(j)[0])+
							Math.abs(chicken_house.get(chicken_open.get(i)[diff])[1]-house.get(j)[1]));
				}
				sum+=min;
			}
			chicken_load[i] = sum;
		}
		int min_chicken_load = Integer.MAX_VALUE;
		for(int i=0;i<chicken_load.length;i++)
			min_chicken_load = Math.min(min_chicken_load, chicken_load[i]);
		System.out.println(min_chicken_load);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==M) {
			chic_count++;
			Integer[] check = new Integer[M];
			for(int i=0;i<M;i++) {
				check[i] = numbers[i];
			}
			chicken_open.add(check);
			return;
		}
		
		for(int i=start;i<chicken_house.size();i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}