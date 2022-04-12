import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int l;
    static int[][] map;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static boolean[][] sloperight;
    static boolean[][] slopedown;
    final static int right = 0;
    final static int down = 1;
    static int count = 0;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        String first = br.readLine();
        String[] nl = first.split(" ");
        n = Integer.parseInt(nl[0]);
        l = Integer.parseInt(nl[1]);
        map = new int[n][n];
        sloperight = new boolean[n][n];
        slopedown = new boolean[n][n];
        for(int i = 0; i<n;i++){
            String next = br.readLine();
            String[] each = next.split(" ");
            for(int j = 0; j<n;j++){
                map[i][j] =Integer.parseInt(each[j]);
            }
        }
        for(int i = 0; i<n;i++){
            flag = true;
            gofoward(right,i,0,map[i][0]);
            if(flag == true) count++;
            flag = true;
            gofoward(down,0,i,map[0][i]);
            if(flag == true) count ++;
        }
        System.out.println(count);

    }
    public static void gofoward(int d, int x, int y, int prev){
        if(x>=n||y>=n) return;
        if(map[x][y] == prev) gofoward(d,x+dx[d],y+dy[d],map[x][y]);
        else if(isSlopePossible(d, x,y,prev)){
            if(map[x][y] == prev -1){
                for(int i = 0; i<=l-1;i++) {
                    if(d == 0) sloperight[x+dx[d]*i][y+dy[d]*i] = true;
                    else slopedown[x+dx[d]*i][y+dy[d]*i] = true;
                }
                gofoward(d,x+dx[d]*l,y+dy[d]*l,map[x][y]);
            }
            else{
                for(int i = 1; i<=l;i++) {
                    if(d == 0)sloperight[x-dx[d]*i][y-dy[d]*i] = true;
                    else slopedown[x-dx[d]*i][y-dy[d]*i] = true;
                }
                gofoward(d,x+dx[d],y+dy[d],map[x][y]);
            }
        }
        else{
            flag =false;
            return;
        }
    }
    public static boolean isSlopePossible(int d, int x, int y, int prev){
        if(map[x][y] == prev -1){
            if(x+dx[d]*(l-1)<n && y+dy[d]*(l-1)<n){
                for(int i = 1; i<=l-1;i++){
                    if(map[x+dx[d]*i][y+dy[d]*i]!= map[x][y]) return false;
                }
                return true;
            }
            else{ return false;}
        }
        else if(map[x][y] == prev+1){
            if(x-dx[d]*l>=0 && y-dy[d]*l>=0){
                for(int i = 1; i<=l;i++){
                    if(map[x-dx[d]*i][y-dy[d]*i]!= map[x-dx[d]][y-dy[d]]) return false;
                    if(d == 0){
                    if(sloperight[x-dx[d]*i][y-dy[d]*i] == true) return false;}
                    else {
                        if(slopedown[x-dx[d]*i][y-dy[d]*i] == true) return false;}
                    }
                return true;
            }else{return false;}}
            return false;
        }
    }
