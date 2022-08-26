package baekjoon.silver;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class S2_12891 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(in.readLine());
		int[] acgt = new int[4];
		int[] default_acgt = new int[4];
		char[] alph = {'A', 'C','G','T'};
		int S = Integer.parseInt(str.nextToken());
		int P = Integer.parseInt(str.nextToken());
		String pass = in.readLine();
		int cnt = 0;
		str = new StringTokenizer(in.readLine());
		
		for(int i=0;i<4;i++)
			default_acgt[i] = Integer.parseInt(str.nextToken());
		Queue<Character> queue = new LinkedList<>();
		for(int i=0;i<S;i++) {
			boolean yn=true;
			char now = pass.charAt(i);
			queue.add(now);
			for(int j=0;j<4;j++) {
				if(now==alph[j]) {
					acgt[j]++;
					break;
				}
			}
			if(i>=P-1) {
				for(int j=0;j<4;j++) {
					if(default_acgt[j]>acgt[j]) {
						yn=!yn;
						break;
					}
				}
				if(yn) cnt++;
				now = queue.remove();
				for(int j=0;j<4;j++) {
					if(now==alph[j]) {
						acgt[j]--;
						break;
					}
				}
			}
			
		}
		System.out.println(cnt);
	}
}