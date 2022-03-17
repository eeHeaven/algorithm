import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static char[][] candy;
    static boolean[][] visited;
    static int maxrow = Integer.MIN_VALUE;
    static int maxcol = Integer.MIN_VALUE;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        n = Integer.parseInt(first);
        candy = new char[n][n];
        for (int i = 0; i < n; i++) {
            String next = br.readLine();
            for (int j = 0; j < n; j++) candy[i][j] = next.charAt(j);
        }

        changecandy();
        System.out.println(max);
    }

    public static void changecandy() {
        countcandyinrow(0,1,candy[0][0],1);
        countcandyincol(1,0,candy[0][0],1);
        max = Math.max(max,maxcol);
        max = Math.max(max,maxrow);
        boolean[][] isChanged = new boolean[n * n + 1][n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j+1<n){
                if (candy[i][j] != candy[i][j + 1] && !isChanged[i * n + j + 1][i * n + j + 2]) {
                    switchCandy(i,j,i,j+1);
                    countcandyinrow(0,1,candy[0][0],1);
                    countcandyincol(1,0,candy[0][0],1);
                    max = Math.max(max,maxcol);
                    max = Math.max(max,maxrow);
                    switchCandy(i,j,i,j+1);
                    isChanged[i * n + j + 1][i * n + j + 2] = true;
                    isChanged[i * n + j + 2][i * n + j + 1] = true;
                }}
                if(i+1<n){
                if (candy[i][j] != candy[i+1][j] && !isChanged[i * n + j + 1][(i+1) * n + j +1]) {
                    switchCandy(i,j,i+1,j);
                    countcandyinrow(0,1,candy[0][0],1);
                    countcandyincol(1,0,candy[0][0],1);
                    max = Math.max(max,maxcol);
                    max = Math.max(max,maxrow);
                    switchCandy(i,j,i+1,j);
                    isChanged[i * n + j + 1][(i+1) * n + j +1] = true;
                    isChanged[(i+1) * n + j +1][i * n + j + 1] = true;
                }}
            }
        }
    }
    public static void switchCandy(int x1, int y1, int x2, int y2){
        char temp = candy[x1][y1];
        candy[x1][y1] = candy[x2][y2];
        candy[x2][y2] = temp;
    }
    public static void countcandyinrow(int x, int y,char c,int eatten){
        if(x>=n) return;
    if(y == n){
        maxrow = Math.max(maxrow,eatten);
        if(x+1 == n) return;
        countcandyinrow(x+1,1,candy[x+1][0],1);
    }
   else if(candy[x][y] == c){
        countcandyinrow(x,y+1,c,eatten+1);
    }
    else if( candy[x][y] != c){
        maxrow = Math.max(maxrow,eatten);
        countcandyinrow(x,y+1,candy[x][y],1);
    }
    }
    public static void countcandyincol(int x, int y,char c,int eatten){
        if(y>=n) return;
        if(x == n){
            maxcol = Math.max(maxcol,eatten);
            if(y+1 == n) return;
          countcandyincol(1,y+1,candy[0][y+1],1);
        }
        else if(candy[x][y] == c){
            countcandyincol(x+1,y,c,eatten+1);
        }
        else if( candy[x][y] != c){
            maxcol = Math.max(maxcol,eatten);
            countcandyincol(x+1,y,candy[x][y],1);
        }
    }



}
