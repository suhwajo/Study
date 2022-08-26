package swexpert;

import java.io.*;
import java.util.*;
public class D5_1247 {
	static int min, N;
	static Pos house, company, clients[], select_dist[];
	static boolean isSelected[];
	static public class Pos{
		public int x, y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			N = Integer.parseInt(in.readLine());
			min = Integer.MAX_VALUE;
			StringTokenizer str = new StringTokenizer(in.readLine());
			house = new Pos(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
			company = new Pos(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
			clients = new Pos[N];
			select_dist = new Pos[N+1];
			isSelected = new boolean[N];
			select_dist[0] = company;
			for(int client=0;client<N;client++)
				clients[client] = new Pos(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
			distance(1, 0);
			sb.append(min+"\n");
		}
		System.out.println(sb);
	}
	public static void distance(int cnt, int dist_sum) {
		if(min<dist_sum) return;
		if(cnt==N+1) {
			dist_sum+=(int)Math.abs(house.x-select_dist[N].x)+(int)Math.abs(house.y-select_dist[N].y);
			if(min>dist_sum) min=dist_sum;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			select_dist[cnt] = clients[i];
			isSelected[i] = true;
			
			int now_dist = (int)Math.abs(select_dist[cnt].x-select_dist[cnt-1].x)+(int)Math.abs(select_dist[cnt].y-select_dist[cnt-1].y);
			distance(cnt+1, dist_sum+now_dist);
			isSelected[i] = false;
		}
	}
}