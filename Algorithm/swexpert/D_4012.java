package swexpert;

import java.io.*;
import java.util.*;
public class D_4012 {
    static int[][] synergy;
    static int N, comb_cnt, diff_min;
    static boolean[] menu;
    static int[] first, second;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        for(int test_case = 1;test_case<=T;test_case++) {
            N = Integer.parseInt(in.readLine());
            synergy = new int[N][N];
            for(int i=0;i<N;i++) {
                StringTokenizer str = new StringTokenizer(in.readLine());
                for(int j=0;j<N;j++)
                    synergy[i][j] = Integer.parseInt(str.nextToken());
            }
            comb_cnt=0;
            diff_min = Integer.MAX_VALUE;
            menu = new boolean[N];
            first = new int[N/2];
            second = new int[N/2];
            comb(0,0);
            System.out.println("#"+test_case+" "+diff_min);
        }
    }
     
    public static void comb(int cnt, int start) {
        if(cnt!=0 && start!=0 && menu[0]==false)
            return;
        if(cnt==N/2) {
            comb_cnt++;
            min_check();
            return;
        }
        for(int i=start;i<N;i++) {
            first[cnt]=i;
            menu[i]=true;
            comb(cnt+1, i+1);
            menu[i]=false;
        }
    }
    public static void min_check() {
        int cnt=0;
        for(int i=0;i<N;i++) {
            if(!menu[i])
                second[cnt++]=i;
        }
        int sum_f=0, sum_s=0;
        for(int i=0;i<N/2;i++) {
            for(int j=0;j<N/2;j++) {
                sum_f+=synergy[first[i]][first[j]];
                sum_s+=synergy[second[i]][second[j]];
            }
        }
        diff_min = Math.min(diff_min, Math.abs(sum_s-sum_f));
    }
}