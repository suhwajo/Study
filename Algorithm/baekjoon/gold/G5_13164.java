package baekjoon.gold;
import java.io.*;
import java.util.*;
public class G5_13164 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int[] child = new int[N];
		int[] num = new int[N-1];
		str = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++)
			child[i] = Integer.parseInt(str.nextToken());
		int cnt=0;
		for(int i=0;i<N-1;i++)
			num[i] = child[i+1]-child[i];
		Arrays.sort(num);
		int sum = 0;
		for(int i=0;i<N-K;i++) {
			sum+=num[i];
		}
		System.out.println(sum);
	}

}
