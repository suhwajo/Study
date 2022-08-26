package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class B2_1076 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] color = {"black", "brown","red","orange","yellow","green","blue","violet","grey","white"};
		String first = in.readLine(), second = in.readLine(), thrid = in.readLine();
		int first_num=-1, second_num=-1, thrid_num=-1;
		for(int i=0;i<10;i++) {
			if(first.equals(color[i])) first_num = i;
			if(second.equals(color[i])) second_num = i;
			if(thrid.equals(color[i])) thrid_num = i;
		}
		long sum = ((first_num*10)+second_num)*(long)Math.pow(10,thrid_num);
		System.out.println(sum);
	}

}
