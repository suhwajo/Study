package swexpert;

import java.util.Scanner;

public class D2_1974 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
         
        for(int i=0;i<num;i++) {
            int[][] sudoku = new int[9][9];
            boolean ft=true;
            for(int j=0;j<9;j++) {
                for(int k=0;k<9;k++)
                    sudoku[j][k]=in.nextInt();
            }
            for(int j=0;j<9;j++) {
                boolean[] check = new boolean[9];
                for(int k=0;k<9;k++) {
                    check[sudoku[j][k]-1]=true;
                }
                for(int k=0;k<9;k++) {
                    if(check[k]==false) {
                        ft=false;
                        break;
                    }
                }
            }
 
            for(int j=0;j<9;j++) {
                boolean[] check = new boolean[9];
                for(int k=0;k<9;k++) {
                    check[sudoku[k][j]-1]=true;
                }
                for(int k=0;k<9;k++) {
                    if(check[k]==false) {
                        ft=false;
                        break;
                    }
                }
            }
             
            for(int j=0;j<7;j+=3) {
                for(int k=0;k<7;k+=3) {
                    boolean[] check = new boolean[9];
                    int r=j+3;
                    int c=k+3;
                    for(int first=j;first<r;first++) {
                        for(int second=k;second<c;second++)
                            check[sudoku[first][second]-1]=true;
                    }
                    for(int bool_check=0;bool_check<9;bool_check++) {
                        if(check[bool_check]==false) {
                            ft=false;
                            break;
                        }
                    }
                }
            }
            if(ft==false)
                System.out.println("#"+(i+1)+" "+0);
            else
                System.out.println("#"+(i+1)+" "+1);
        }
    }
}
