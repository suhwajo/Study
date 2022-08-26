package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class S3_1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		boolean[] now_switch = new boolean[T]; //true - 1 false-0
		StringTokenizer str = new StringTokenizer(in.readLine());
		
		for(int i=0;i<T;i++) {
			int input = Integer.parseInt(str.nextToken());
			if(input==1) now_switch[i]=true;
			else now_switch[i]=false;
		}
		
		int student_num = Integer.parseInt(in.readLine());
		int[] gender = new int[student_num];
		int[] switch_num = new int[student_num];
		
		for(int i=0;i<student_num;i++) {
			str = new StringTokenizer(in.readLine());
			gender[i] = Integer.parseInt(str.nextToken());
			switch_num[i] = Integer.parseInt(str.nextToken());
		}
		
		for(int i=0;i<student_num;i++) {
			if(gender[i]==1) {
				int change_swit = switch_num[i];
				int mult = 2;
				int now = change_swit-1;
				now_switch[now]=!now_switch[now];
				change_swit*=mult;
				
				while(change_swit<=T) {
					now = change_swit-1;
					now_switch[now]=!now_switch[now];
					change_swit=switch_num[i]*(++mult);
				}
			} else {
				int mult = 1;
				int left=switch_num[i]-mult-1, right=switch_num[i];
				now_switch[switch_num[i]-1]=!now_switch[switch_num[i]-1];

				while(left>=0 &&right<T) {
					if(now_switch[left]==now_switch[right]) {
						now_switch[left]=!now_switch[left];
						now_switch[right]=!now_switch[right];
						left-=1;
						right+=1;
					} else break;
				}
			}
		}
		for(int i=0;i<T;i++) {
			if(now_switch[i]==true)
				System.out.print(1+" ");
			else System.out.print(0+" ");
			if((i+1)%20==0)
				System.out.println();
		}
	}
}