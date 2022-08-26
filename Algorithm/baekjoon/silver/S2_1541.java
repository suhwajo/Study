package baekjoon.silver;
import java.io.*;
import java.util.*;
public class S2_1541 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String fol = in.readLine();
		int sum=0, minus_sum=0, minus_num=0, num=0;
		boolean minus=false;

		for(int i=0;i<fol.length();i++) {
			boolean check = Character.isDigit(fol.charAt(i));
			if(!check) {
				if(fol.charAt(i)=='+' && !minus) {
					sum+=num;
					num=0;
				}
				else if(fol.charAt(i)=='-') {
					if(!minus) {
						sum+=num;
						num=0;
					}
					minus=true;
				}
				minus_sum+=minus_num;
				minus_num=0;
				sum+=num;
				num=0;
			}
			else if(check && !minus) num = num*10+(fol.charAt(i)-'0');
			else if(check && minus) minus_num = minus_num*10+(fol.charAt(i)-'0');
		}
		minus_sum+=minus_num;
		sum+=num;
		System.out.println(sum-minus_sum);
	}
}