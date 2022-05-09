import java.io.*;
import java.util.*;

public class Main{

    final static int NORTH = 0;
    final static int SOUTH = 2;
    final static int WEST = 3;
    final static int EAST = 1;
    final static int[] dx = {-1,0,1,0};
    final static int[] dy ={0,1,0,-1};
    static boolean[][] clean;
    static int[][] room;
    static int count;
    static int n,m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        clean = new boolean[n][m];
        StringTokenizer second = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(second.nextToken());
        int y = Integer.parseInt(second.nextToken());
        int dir = Integer.parseInt(second.nextToken());
        room = new int[n][m];
        for(int i = 0; i<n;i++){
            StringTokenizer each = new StringTokenizer(br.readLine());
            for(int j = 0; j<m;j++){
                int temp = Integer.parseInt(each.nextToken());
                room[i][j] = temp;
                if(temp == 1) clean[i][j] = true;
            }
        }

        dfs(x,y,dir);
        System.out.println(count);

    }
    public static void dfs(int x, int y, int dir){
        cleanroom(x,y);
        for(int i=3;i>=0;i--){
            int left = (dir+i)%4;
            if(isnotcleaned(x,y,left)){
                dfs(x+dx[left],y+dy[left],left);
                return;
            }
        }
        int backdir = (dir+2)%4;
        if(check(x,y,backdir)){
            dfs(x+dx[backdir],y+dy[backdir],dir);
        }
    }
    public static void cleanroom(int x, int y){
        if(!clean[x][y]){
            clean[x][y] = true;
            count++;
        }
    }
    public static boolean check(int x, int y, int dir){
        int rx = x+dx[dir];
        int ry = y+dy[dir];
        if(rx<0||ry<0||rx>=n||ry>=m) return false;
        if(room[rx][ry]==1) return false;
        return true;
    }
    public static boolean isnotcleaned(int x, int y, int dir){
        if(!check(x,y,dir))return false;
        int rx = x+dx[dir];
        int ry = y+dy[dir];
        if(clean[rx][ry]) return false;
        return true;
    }

}
