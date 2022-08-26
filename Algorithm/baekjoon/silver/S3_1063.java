package baekjoon.silver;

import java.io.*;
import java.util.*;

public class S3_1063 {
	static int[] dx = {0,0,1,-1,-1,-1,1,1};
	static int[] dy = {1,-1,0,0,1,-1,1,-1};
	static String[] com = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(in.readLine());
		String king_str = str.nextToken(), rock_str = str.nextToken();
		int N = Integer.parseInt(str.nextToken());
		Pos king = new Pos(7-(king_str.charAt(1)-'1'), king_str.charAt(0)-'A');
		Pos rock = new Pos(7-(rock_str.charAt(1)-'1'), rock_str.charAt(0)-'A');
		for(int i=0;i<N;i++) {
			String now_com = in.readLine();
			int now=-1;
			for(int j=0, size = com.length;j<size;j++) {
				if(now_com.equals(com[j])){
					now = j;
					break;
				}
			}
			int temp_x = king.x+dx[now], temp_y = king.y+dy[now];
			if(temp_x<0 || temp_y<0|| temp_x>=8 || temp_y>=8) continue;
			if(temp_x == rock.x && temp_y==rock.y) {
				int rock_temp_x = rock.x+dx[now], rock_temp_y = rock.y+dy[now];
				if(rock_temp_x<0 || rock_temp_y<0|| rock_temp_x>=8 || rock_temp_y>=8) continue;
				rock.x = rock_temp_x;
				rock.y = rock_temp_y;
			}
			king.x = temp_x;
			king.y = temp_y;
		}
		sb.append((char)(king.y+'A'));
		sb.append((7-king.x+1)+"\n");
		sb.append((char)(rock.y+'A'));
		sb.append((7-rock.x+1));
		System.out.println(sb);
	}

}
