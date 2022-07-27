package practice_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D1226 {
	static String[] miro=new String[16];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=10;
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int ca = Integer.parseInt(sc.nextLine());
			miro = new String[16];
			
			for(int i=0;i<16;i++) {
				miro[i]=sc.nextLine();
			}
			
			System.out.println("#"+test_case+" "+bfs()); 
		}
	}
	
	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[16][16];
		int dir_x[] = {-1,0,1,0};
		int dir_y[] = {0,-1,0,1};
		
		q.add(new int[] {1,1});
		visited[1][1]=true;
		
		while(!q.isEmpty()) {
			int[] a= q.poll();
			
			if(miro[a[0]].charAt(a[1])=='3') {
				return 1;
			}
			
			for(int i=0;i<4;i++) {
				int x=a[0]+dir_x[i];
				int y=a[1]+dir_y[i];
				
				if(x>=0&&x<16&&y>=0&&y<16) {
					if(!visited[x][y] && miro[x].charAt(y)!='1') {
						q.add(new int[] {x,y});
						visited[x][y] = true;
					}
				}
			}
		}
		
		
		return 0;
	}
}
