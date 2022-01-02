import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] area;
    static int safecount;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오고 초기 area 상태 설정, 가장 낮은 높이&가장높은 높이 구하기
        String input = br.readLine();
       n= Integer.parseInt(input);
       area = new int[n][n];
       int lowest = 101;
       int highest = 0;
       for(int i = 0; i<n;i++){
           String next = br.readLine();
           String[] each = next.split(" ");
           for(int j = 0; j<n;j++) {
               int thisnum  = Integer.parseInt(each[j]);
               highest = Math.max(highest,thisnum);
               lowest = Math.min(lowest, thisnum);
               area[i][j] = thisnum;}
       }
       if(lowest==highest){
           System.out.println(1);
           return;
       }
       for(int i = lowest;i<highest;i++){
           max = Math.max(max, safezoneCount(i));
       }
        System.out.println(max);
        }
        public static int safezoneCount(int rain){
        boolean[][] drown = new boolean[n][n];
        int count = 0;
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(area[i][j] <=rain) drown[i][j] = true;
            }
        }
            for(int i = 0; i<n;i++){
                for(int j = 0; j<n;j++){
                    safecount = 0;
                    dfs(i,j,drown);
                    if(safecount>=1) count++;
                }
            }
            return count;
        }

        public static void dfs(int x, int y, boolean[][] drown){
        if(x<0||y<0||x>=n||y>=n) return;
        if(drown[x][y] == true) return;
        safecount ++; drown[x][y] = true;
        dfs(x-1,y,drown);
        dfs(x+1,y,drown);
        dfs(x,y-1,drown);
        dfs(x,y+1,drown);
        }
    }
