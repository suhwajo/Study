package swexpert;

import java.io.*;
public class D3_1873 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static int direction(char my_dir) {
		switch(my_dir) {
		case '^':
			return 0;
		case '>':
			return 1;
		case 'v':
			return 2;
		case '<':
			return 3;
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] hw = in.readLine().split(" ");
			int H = Integer.parseInt(hw[0]), W = Integer.parseInt(hw[1]);
			char[][] map = new char[H][W];
			int[] now = new int [2];
			int dir=-1; // 0상 1우 2하 3좌
			
			for(int i=0;i<H;i++) {
				String str = in.readLine();
				for(int j=0;j<W;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='<'|| map[i][j]=='>') {
						now[0]=i;
						now[1]=j;
						dir = direction(map[i][j]);
					}
				}
			}

			int recom_num = Integer.parseInt(in.readLine());
			String recom = in.readLine();
			
			for(int i=0;i<recom_num;i++) {
				char now_recom = recom.charAt(i);
				int temp_x=now[0]+dx[dir], temp_y=now[1]+dy[dir];
				if(now_recom=='S') {
					while(true) {
						if(temp_x>=H || temp_x<0 ||	temp_y>=W || temp_y<0 || map[temp_x][temp_y]=='#') break;
						else if(map[temp_x][temp_y]=='.' || map[temp_x][temp_y]=='-') {
							temp_x+=dx[dir];
							temp_y+=dy[dir];
						} else if(map[temp_x][temp_y]=='*') {
							map[temp_x][temp_y]='.';
							break;
						}
					}
				}else {
					if(now_recom=='U') {
						dir=0;
						map[now[0]][now[1]]='^';
					} else if(now_recom=='D') {
						dir=2;
						map[now[0]][now[1]]='v';
					} else if(now_recom=='L') {
						dir=3;
						map[now[0]][now[1]]='<';
					} else {
						dir=1;
						map[now[0]][now[1]]='>';
					}
					temp_x=now[0]+dx[dir];
					temp_y=now[1]+dy[dir];
					if(temp_x<H && temp_x>=0 &&	temp_y<W && temp_y>=0 &&map[temp_x][temp_y]=='.') {
						map[temp_x][temp_y]=map[now[0]][now[1]];
						map[now[0]][now[1]]='.';
						now[0]=temp_x;
						now[1]=temp_y;
					}
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
