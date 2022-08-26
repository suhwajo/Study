package swexpert;

import java.io.*;
import java.util.*;
public class D_4013 {
	static int MEET_LEFT = 6, MEET_RIGHT = 2;
	static int turn1[] = {1,-1,1,-1}, turn2[] = {-1,1,-1,1};
	static List<Integer> ns[];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(str.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			int K = Integer.parseInt(in.readLine());
			ns= new ArrayList[4];
			for(int i=0;i<4;i++) {
				ns[i] = new ArrayList<Integer>();
				str = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; j++)
					ns[i].add(Integer.parseInt(str.nextToken()));
			}
			
			for(int k=0;k<K;k++) {
				// 각 톱니 회전시킨 결과
				str = new StringTokenizer(in.readLine());
				int magnet_num = Integer.parseInt(str.nextToken())-1;
				int dir = Integer.parseInt(str.nextToken()); //시계 1 / 반시계 -1
				boolean[] turn = new boolean[4];
				turn[magnet_num] = true;
				if(magnet_num==0 || magnet_num==1) { // 1234
					turn = check(turn, 0, 1);
					turn = check(turn, 1, 2);
					turn = check(turn, 2, 3);
				}else if(magnet_num==2 || magnet_num==3) { // 3241
					turn = check(turn, 2, 3);
					turn = check(turn, 1, 2);
					turn = check(turn, 0, 1);
				} else System.out.println("잘못된 magnet 정보");
				
				int turn_dir[];
				if(turn1[magnet_num]==dir) turn_dir = turn1;
				else turn_dir = turn2;
				for(int i=0;i<4;i++) {
					if(turn[i]==false) continue;
					ns[i] = turn_finish(ns[i], turn_dir[i]);
				}
			}
			
			int score = 0;
			for (int i = 0; i < 4; i++) { // n(1)극 2^i / s(0)극 0
//				if(ns[i].get(0)==1) score+=(int)Math.pow(2, i);
				score+=ns[i].get(0)==1 ? (int)Math.pow(2, i) : 0;
			}
			sb.append(score+"\n");
		}
		System.out.println(sb);

	}
	public static List<Integer> turn_finish(List<Integer> nowmagnet, int dir){
		// 시계방향 7->0 / 반시계 0->7
		if(dir==-1) {
			int temp = nowmagnet.get(0);
			nowmagnet.remove(0);
			nowmagnet.add(7, temp);
		} else if(dir==1) {
			int temp = nowmagnet.get(7);
			nowmagnet.remove(7);
			nowmagnet.add(0, temp);
		}
		return nowmagnet;
	}
	public static boolean[] check(boolean[] now_check, int a, int b) {
		if(ns[a].get(MEET_RIGHT)!=ns[b].get(MEET_LEFT) && (now_check[a]||now_check[b])) {
			now_check[a] = true;
			now_check[b] = true;
		}
		return now_check;
	}
}