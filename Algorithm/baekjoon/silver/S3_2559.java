package baekjoon.silver;
import java.io.*;
import java.util.*;
public class S3_2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int max=0;
		str = new StringTokenizer(in.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<K;i++) {
			int add = Integer.parseInt(str.nextToken());
			queue.add(add);
			max+=add;
		}
		int before = max;
		for(int i=K;i<N;i++) {
			int poll = queue.poll();
			int add = Integer.parseInt(str.nextToken());
			queue.add(add);
			before = before-poll+add;
			max = Math.max(max, before);
		}
		System.out.println(max);
	}

}
