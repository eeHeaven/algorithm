import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int house = 0;
    static ArrayList<Integer> village = new ArrayList<>();
    static char[][] town;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
     String first = br.readLine();
     n= Integer.parseInt(first);
     town = new char[n][n];
     visit = new boolean[n][n];
     for(int i = 0; i<n;i++){
         String next = br.readLine();
         for(int j = 0; j<n;j++)
             town[i][j] = next.charAt(j);
     }
     for(int i = 0; i<n;i++){
         for(int j = 0; j<n;j++){
             if(town[i][j] == '1' && !visit[i][j]){
                 house = 0;
                 bfs(i,j);
                 village.add(house);
             }
         }
     }
     Collections.sort(village);
        System.out.println(village.size());
        for(int i = 0; i<village.size();i++){
            System.out.println(village.get(i));
        }
    }
    public static void bfs(int x, int y){
        if(x<0||y<0||x>=n||y>=n) return;
        if(town[x][y] =='1' && visit[x][y] ==false){
            house++;
            visit[x][y] = true;
            for(int i = 0; i<4;i++) bfs(x+dx[i],y+dy[i]);
        }
    }
}
