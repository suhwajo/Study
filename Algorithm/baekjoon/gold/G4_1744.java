package baekjoon.gold;
import java.io.*;
import java.util.*;
public class G4_1744 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] num = new int[T];
		int zero=0, cnt=0;
		for(int i=0;i<T;i++) {
			int now = Integer.parseInt(in.readLine());
			if(now==0) { 
				zero++;
				continue;
			}
			num[cnt++]=now;
		}
		
		Arrays.sort(num,0,cnt);
		
		int now_back=T-1-zero, now_front = 0;
		int sum=0;
		while(true) {
			if (now_back<0 || now_front>now_back) break;
			if(now_back-1>=0 && num[now_back]>1 && num[now_back-1]>1) {
				sum+=(num[now_back]*num[now_back-1]);
				now_back-=2;
			} else if(num[now_back]>=1) {
				sum+=num[now_back];
				now_back--;
			} else if(now_front+1<T-zero && num[now_front]<0 && num[now_front+1]<0) {
				sum+=(num[now_front]*num[now_front+1]);
				now_front+=2;
			} else if(num[now_front]<0 && zero>0) {
				zero--;
				now_front++;
			} else {
				sum+=num[now_front];
				now_front++;
			}
		}
		System.out.println(sum);
	}
}
