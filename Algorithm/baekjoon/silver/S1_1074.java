package baekjoon.silver;
import java.io.*;
import java.util.*;
public class S1_1074 {
	static int N, r, c;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		N = Integer.parseInt(str.nextToken());
		r = Integer.parseInt(str.nextToken());
		c = Integer.parseInt(str.nextToken());
		int real_size = (int)Math.pow(2, N);
		System.out.println(z_map(0,0, real_size));
		
	}
	private static int z_map(int x, int y, int size) {
		if(size==1)
			return 0;
		int half = size/2;
		if(r<x+half && c<y+half)
			return z_map(x, y, half);
		else if(r<x+half && c<y+size)
			return z_map(x, y+half, half)+(int)Math.pow(half, 2);
		else if(r<x+size && c<y+half)
			return z_map(x+half, y, half)+(int)Math.pow(half, 2)*2;
		else 
			return z_map(x+half, y+half, half)+(int)Math.pow(half, 2)*3;
	}
}