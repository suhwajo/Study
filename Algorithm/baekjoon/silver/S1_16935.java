package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;
public class S1_16935 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		int R = Integer.parseInt(str.nextToken());
		int map[][] = new int [N][M];
		
		for(int i=0;i<N;i++) {
			str = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++)
				map[i][j] = Integer.parseInt(str.nextToken());
		}
		
		str = new StringTokenizer(in.readLine());		
		for(int i=0;i<R;i++) {
			int recom = Integer.parseInt(str.nextToken());
			if(recom==1) map = up_down(map);
			else if(recom==2) map = left_right(map);
			else if(recom==3) map = right_90(map);
			else if(recom==4) map = left_90(map);
			else if(recom==5) map = four_right(map);
			else if(recom==6) map = four_left(map);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		
	}
	
	public static int[][] up_down(int[][] map) {
		int[][] result = new int[N][M];
		int half = N/2;
		for(int i=0;i<half;i++) {
			for(int j=0;j<M;j++) {
				result[i][j]=map[N-1-i][j];
				result[N-1-i][j] = map[i][j];
			}
		}
		
		return result;
	}
	
	public static int[][] left_right(int[][] map) {
		int[][] result = new int[N][M];
		int half = M/2;
		for(int j=0;j<half;j++) {
			for(int i=0;i<N;i++) {
				result[i][j]=map[i][M-1-j];
				result[i][M-1-j] = map[i][j];
			}
		}
		return result;
	}

	
	public static int[][] right_90(int[][] map) {
		int[][] result = new int[M][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				 result[j][N-1-i] = map[i][j];
			}
		}
		int temp = N;
		N=M;
		M=temp;
		return result;
	}

	public static int[][] left_90(int[][] map) {
		int[][] result = new int[M][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				 result[M-1-j][i] = map[i][j];
			}
		}
		int temp = N;
		N=M;
		M=temp;
		return result;
	}

	
	public static int[][] four_right(int[][] map) {
		int[][] result = new int[N][M];
		int[] start_x = {0,0,N/2,N/2};
		int[] start_y = {0,M/2,M/2,0};
		
		for(int i=0;i<4;i++) {
			int index = (i+1)%4;
			int after_x = start_x[index];
			for(int x=start_x[i];x<start_x[i]+N/2;x++) {
				int after_y = start_y[index];
				for(int y=start_y[i];y<start_y[i]+M/2;y++) {
					result[after_x][after_y] = map[x][y];
					after_y++;
				}
				after_x++;
			}
		}		
		return result;
	}
	
	public static int[][] four_left(int[][] map) {
		int[][] result = new int[N][M];
		int[] start_x = {0,0,N/2,N/2};
		int[] start_y = {0,M/2,M/2,0};
		
		for(int i=0;i<4;i++) {
			int index = (i-1+4)%4;
			int before_x = start_x[index];
			for(int x=start_x[i];x<start_x[i]+N/2;x++) {
				int before_y = start_y[index];
				for(int y=start_y[i];y<start_y[i]+M/2;y++) {
					result[before_x][before_y] = map[x][y];
					before_y++;
				}
				before_x++;
			}
		}		
		return result;
	}

}