package swexpert;

import java.util.Scanner;
public class D2_1959{
    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner(System.in);
         
        int t=in.nextInt();
        for(int i=0;i<t;i++) {
            int N=in.nextInt();
            int M=in.nextInt();
            int[] A=new int[N];
            int[] B=new int[M];
            int max=0;
             
            for(int j=0;j<N;j++)
                A[j]=in.nextInt();
            for(int j=0;j<M;j++)
                B[j]=in.nextInt();
             
            if(N>M){
                for(int j=0;j<=N-M;j++) {
                    int sum=0;
                    for(int k=0;k<M;k++)
                        sum+=B[k]*A[j+k];
                        if(max<sum)
                            max=sum;
                }
            }
            else{
                for(int j=0;j<=M-N;j++) {
                    int sum=0;
                    for(int k=0;k<N;k++)
                        sum+=A[k]*B[j+k];
                    if(max<sum)
                        max=sum;
                }
            }       
            System.out.println("#"+(i+1)+" "+max);
        }
    }
}