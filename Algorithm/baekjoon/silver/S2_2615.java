package baekjoon.silver;
import java.io.*;

public class S2_2615 {
	static int[] dx = {0,1,1,-1};
	static int[] dy = {1,1,0,1};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] game_num = new int[19][19];
		for(int i=0;i<19;i++) {
			String[] line = in.readLine().split(" ");
			for(int j=0;j<19;j++) {
				game_num[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(game_num[i][j]==1 || game_num[i][j]==2) {
					for(int k=0;k<dx.length;k++) {
						int now_x = i;
						int now_y = j;
						int count=0;
						
						if((i-dx[k])>=0 && (i-dx[k])<19 && (i-dy[k])>=0 &&(i-dy[k])<19 && game_num[i-dx[k]][j-dy[k]]==game_num[i][j])
							continue;
						while(now_x>=0 && now_y>=0&&now_x<19&&now_y<19&&game_num[now_x][now_y]==game_num[i][j]) {
							count++;
							now_x+=dx[k];
							now_y+=dy[k];
						}
						if(count==5) {
							System.out.println(game_num[i][j]);
							System.out.println((i+1)+" "+(j+1));
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}

}