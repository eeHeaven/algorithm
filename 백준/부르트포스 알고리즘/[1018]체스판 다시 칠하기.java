import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String MN = br.readLine();
        String[]MandN = MN.split(" ");
        int M = Integer.parseInt(MandN[0]); //세로줄
        int N = Integer.parseInt(MandN[1]); // 가로줄

        int[][] board = new int[M][N];
        for(int i = 0; i<M;i++){
            String BW = br.readLine();
            for(int j = 0; j<N;j++){
                if(BW.charAt(j)=='B') board[i][j] = -1; //black
                else board[i][j] = 1; // white
            }
        }
        int answer = 50000;
        for(int i = 0; i<=M-8;i++){
            for(int j = 0; j<=N-8; j++){
                int prev = 0;
                int count = 0;
                for(int k = i; k<i+8;k++){
                   prev=prev*-1;
                    for(int l = j; l<j+8;l++){
                        int cur = board[k][l];
                        if(cur == prev) {count++;
                        cur = cur*-1;}
                        prev = cur;
                    }
                }
                answer = Math.min(answer,count);
                count = 0;
                prev = prev*-1;
                for(int k = i; k<i+8;k++){ // 이거 굳이 두번 안하고 걍 Math.min(count,64-count)해도 됐을 듯 첫번째칸 유지하고 바꿔칠한 값이 count라면 그 반대로 첫번째칸 색 바꾸는게 64-count 일테니 
                    prev=prev*-1;
                    for(int l = j; l<j+8;l++){
                        int cur = board[k][l];
                        if(cur == prev) {count++;
                            cur = cur*-1;}
                        prev = cur;
                    }
                }
                answer = Math.min(answer,count);
            }
        }

        System.out.println(answer);
    }
}
