import java.io.*;
import java.util.*;

public class Main {

    public static int n,m;
    public static int[][] wall, count;
    public static final int WALL = 1;
    public static final int ABLE = 2;
    public static final int[] dx = {-1,1,0,0};
    public static final int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        wall = new int[n+2][m+2];
        count = new int[n+2][m+2];
        for(int i = 1; i<=n;i++){
            String each = br.readLine();
            for(int j = 1;j<=m;j++){
                int temp = Character.getNumericValue(each.charAt(j-1));
                if(temp == 1) wall[i][j] = ABLE;
                else wall[i][j] = WALL;
            }
        }

        Queue<Location> q = new LinkedList<>();
        q.add(new Location(1,1));
        count[1][1] = 1;
        while(!q.isEmpty()){
            Location l = q.poll();
            int x = l.x;
            int y = l.y;
            if(x == n&&y ==m) {
                System.out.println(count[x][y]);
                return;
            }
            for(int i = 0; i<4;i++){
                if(wall[x+dx[i]][y+dy[i]]==ABLE && count[x+dx[i]][y+dy[i]]==0){
                    q.add(new Location(x+dx[i],y+dy[i]));
                    count[x+dx[i]][y+dy[i]] = count[x][y]+1;
                }
            }
        }



    }
}
class Location{
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
