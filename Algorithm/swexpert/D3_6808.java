package swexpert;

import java.util.*;
import java.io.*;
public class D3_6808 {
	static int Win, Lose;
	static int[] gyuyoung, inyoung, inyoung_game;
	static boolean[] inyoung_b;
	public static void game(int cnt) {
		if(cnt==9) {
			int in_score = 0;
			int gyu_score = 0;

			for(int i=0;i<9;i++) {
				if(inyoung_game[i]>gyuyoung[i])
					in_score+=inyoung_game[i]+gyuyoung[i];
				else if(inyoung_game[i]<gyuyoung[i])
					gyu_score+=inyoung_game[i]+gyuyoung[i];
			}
			if(in_score>gyu_score) Win++;
			else if(in_score<gyu_score) Lose++;
		}
		for(int i=0;i<9;i++) {
			if(inyoung_b[i]) continue;
			inyoung_game[cnt]=inyoung[i];
			inyoung_b[i] = true;
			game(cnt+1);
			inyoung_b[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(str.nextToken());

		for(int test_case = 1;test_case<=T;test_case++) {
			boolean[] check = new boolean[19];
			gyuyoung = new int[9];
			inyoung = new int[9];
			inyoung_game = new int[9];
			inyoung_b = new boolean[9];
			str = new StringTokenizer(in.readLine());
			for(int i=0;i<9;i++) {
				inyoung[i] = Integer.parseInt(str.nextToken());
				check[inyoung[i]]=true;
			}
			int cnt_gyu=0;
			for(int i=1;i<19;i++) {
				if(!check[i])
					gyuyoung[cnt_gyu++]=i;
			}
			Win=0;
			Lose=0;
			game(0);
			sb.append("#"+test_case+" "+Win+" "+Lose+"\n");
		}
		System.out.println(sb);
	}
}