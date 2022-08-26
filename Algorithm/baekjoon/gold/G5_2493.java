package baekjoon.gold;
import java.util.*;
import java.io.*;
public class G5_2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] top = new int[N];
		Arrays.fill(top, 0);
		Stack<int[]> stack = new Stack<>();
		StringTokenizer str = new StringTokenizer(in.readLine());
		
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(str.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[1]>=now) {
					System.out.print((stack.peek()[0]+1)+" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty())
				System.out.print(0+" ");
			stack.push(new int[] {i,now});
		}
	}
}