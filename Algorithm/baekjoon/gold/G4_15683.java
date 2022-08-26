package baekjoon.gold;
import java.io.*;
import java.util.*;
public class G4_15683 {
	static int N, M, min_blind;
	static int[] perm, dx = {0,1,0,-1}, dy = {1,0,-1,0};
	static int[][] change_map, map;
	static List<CCTV> cctv;
	static public class CCTV{
		int x, y, method;
		public CCTV(int x, int y, int method) {
			super();
			this.x = x;
			this.y = y;
			this.method = method;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		map = new int [N][M];
		change_map = new int[N][M];
		min_blind = Integer.MAX_VALUE;
		cctv = new ArrayList<G4_15683.CCTV>();
	
		for(int i=0;i<N;i++) {
			str = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				int now = Integer.parseInt(str.nextToken());
				map[i][j] = now;
				if(now>0 && now<6) {
					cctv.add(new CCTV(i, j, now));
				}
			}
		}
		perm = new int[cctv.size()];
		permutation(0);
		System.out.println(min_blind);
		
	}
	static void permutation(int cnt) {
		if(cnt==cctv.size()) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					change_map[i][j] = map[i][j];
				}
			}
			for(int i=0;i<cctv.size();i++)
				watch(perm[i], cctv.get(i));
			check();

			return;
		}
		for(int i=0;i<4;i++) {
			perm[cnt] = i;
			permutation(cnt+1);
		}
	}
	
	static void check() {
		int now_blind=0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(change_map[i][j]==0) now_blind++;
		if(min_blind>now_blind) min_blind=now_blind;
	}
	
	static void watch(int perm, CCTV cctv_now) {
		int cctv_num = cctv_now.method;
		if(cctv_num==1) {
			cctv_work(cctv_now, perm);
		} else if(cctv_num==2) {
			if(perm==0 || perm==2) {
				cctv_work(cctv_now,0);
				cctv_work(cctv_now,2);
			} else if(perm==1 || perm==3) {
				cctv_work(cctv_now,1);
				cctv_work(cctv_now,3);
			}
		}else if(cctv_num==3) {
			if(perm==3) {
				cctv_work(cctv_now,perm);
				cctv_work(cctv_now,perm-3);
			} else {
				cctv_work(cctv_now,perm);
				cctv_work(cctv_now,perm+1);
			}
		}else if(cctv_num==4) {
			if(perm==0) {
				cctv_work(cctv_now,0);
				cctv_work(cctv_now,1);
				cctv_work(cctv_now,2);
			} else if(perm==1) {
				cctv_work(cctv_now,1);
				cctv_work(cctv_now,2);
				cctv_work(cctv_now,3);

			}  else if(perm==2) {
				cctv_work(cctv_now,2);
				cctv_work(cctv_now,3);
				cctv_work(cctv_now,0);
			}  else if(perm==3) {
				cctv_work(cctv_now,3);
				cctv_work(cctv_now,0);
				cctv_work(cctv_now,1);

			} 
		} else if(cctv_num==5) {
			cctv_work(cctv_now,0);
			cctv_work(cctv_now,1);
			cctv_work(cctv_now,2);
			cctv_work(cctv_now,3);
		}
	}
	public static void cctv_work(CCTV cctv_now, int dir) {

		int now_x = cctv_now.x, now_y = cctv_now.y;
		while(true) {
			if(now_x<0 || now_y<0 || now_x>=N || now_y>=M || map[now_x][now_y]==6) break;
			else if(map[now_x][now_y]==0) change_map[now_x][now_y]=-1;
			now_x+=dx[dir];
			now_y+=dy[dir];
		}
	}

}