package baekjoon.silver; no
import java.io.*;
import java.util.*;
public class S1_9081 {
	static int[] str_num, now_str, sort_str, next_str ;
	static int len;
	static boolean[] isSelected;
	static boolean yn, finish;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int test_case=0;test_case<T;test_case++) {
			String str = in.readLine();
			len = str.length();
			str_num = new int[len];
			now_str = new int[len];
			sort_str = new int[len];
			next_str = new int[len];
			isSelected = new boolean[len];
			yn=false;
			finish=false;
			for(int i=0;i<len;i++) {
				int now = str.charAt(i)-'A';
				str_num[i] = now;
				sort_str[i] = now;
			}
			Arrays.sort(sort_str);
			alph_sort(0);
			
			if(!finish)
				for(int i=0;i<len;i++)
					sb.append((char)(str_num[i]+'A'));
			else 
				for(int i=0;i<len;i++)
					sb.append((char)(next_str[i]+'A'));
			sb.append("\n");
			System.out.println(Arrays.toString(str_num));
			System.out.println(Arrays.toString(next_str));
		}
		System.out.println(sb);
	}
	public static void alph_sort(int cnt){
		if(cnt==len) {
			if(finish) return;
			boolean diff=false;
			for(int i=0;i<len;i++)
				if(str_num[i]!=now_str[i]) diff = true;
			if(diff && yn) {
				for(int j=0;j<len;j++) {
					next_str[j] = now_str[j];
				}
				finish = true;
			}
			if (!diff) yn=true;
		}
		
		for(int i=0;i<len;i++) {
			if(isSelected[i]) continue;
			now_str[cnt] = sort_str[i];
			isSelected[i]=true;
			alph_sort(cnt+1);
			isSelected[i] = false;
		}
	}
}

//4
//HELLO
//DRINK
//SHUTTLE
//ZOO

//HELOL
//DRKIN
//SLEHTTU
//ZOO
