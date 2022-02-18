import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int H;
    static int W;
    static int X;
    static int Y;
    static int[][] A;
    static int[][] B;
    static int doubleRstart; // 겹치는 범위 row 시작점
    static int doubleRend; // 겹치는 범위 row 끝나는 지점
    static int doubleCstart; // 겹치는 범위 column 시작점
    static int doubleCend; // 겹치는 범위 column 끝점


    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        String[] hwxy = input.split(" ");
        H = Integer.parseInt(hwxy[0]);
        W = Integer.parseInt(hwxy[1]);
        X = Integer.parseInt(hwxy[2]);
        Y = Integer.parseInt(hwxy[3]);
        A = new int[H][W];
        B = new int[H+X][W+Y];
        doubleRstart = X;
        doubleRend = H-1;
        doubleCstart = Y;
        doubleCend = W-1;

        for(int i = 0;i<H+X;i++){
            String next = br.readLine();
            String[] each = next.split(" ");
            for(int j = 0; j<W+Y;j++){
                B[i][j] = Integer.parseInt(each[j]);
            }
        }

        int tempX = 0;
        int tempY = 0;
        boolean doubleflag = false;
        for(int i = 0;i<H;i++){
            for(int j = 0;j<W;j++){
                if(i>=X&&i<=H-1&&j>=Y&&j<=W-1){// 겹치는 범위의 값
                    doubleflag = true;
                    A[i][j] = B[i][j] - A[tempX][tempY];
                    tempY++;
                }
                else A[i][j] = B[i][j];
            }
            if(doubleflag) tempX++;
            tempY = 0;
        }

        for(int i = 0; i<H;i++){
            for(int j = 0;j<W;j++){
                if(j == 0) System.out.print(A[i][j]);
                else System.out.print(" "+A[i][j]);
            }
            System.out.println();
        }

    }

}
