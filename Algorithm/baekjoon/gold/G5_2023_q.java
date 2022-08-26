package baekjoon.gold;
import java.util.*;
import java.io.*;
public class G5_2023_q {
	static int N, MAX, MIN;
	public static boolean isPrime(int num) {
		for(int i=2;i<Math.sqrt(num);i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}
	public static void dfs(int n, int before) {
		if(n>=MAX) {
			if(before>=MIN && before<MAX)	
				System.out.println(before);
			return;
		}
		for(int i=1;i<=9;i+=2) {
			int now = (n*10)+i;
			if(isPrime(now)) {
				dfs(now, (now-i)/10);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		N = Integer.parseInt(str);
		MAX = (int)Math.pow(10, N);
		MIN = (int)Math.pow(10, N-1);
		int[] prime = {2,3,5,7};
		for(int i=0;i<4;i++)
			dfs(prime[i], 0);
	}
}