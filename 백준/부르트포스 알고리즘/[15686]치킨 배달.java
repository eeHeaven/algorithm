import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static int min = Integer.MAX_VALUE;
   final static int store = 2;
    final static int house = 1;
    static ArrayList<Location> stores = new ArrayList<>();
    static int n;
    static int m;
    static int[][] city;
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오고 초기 area 상태 설정, 가장 낮은 높이&가장높은 높이 구하기
        String input = br.readLine();
       String[] nandm = input.split(" ");
        n = Integer.parseInt(nandm[0]);
        m = Integer.parseInt(nandm[1]);
        city = new int[n][n];
        for(int i = 0; i<n;i++){
            String each = br.readLine();
            String[] block = each.split(" ");
            for(int j =0; j<n;j++){
                city[i][j] = Integer.parseInt(block[j]);
            }
        }
        dfs(0,0,m,city);
        System.out.println(min);

    }

    public static int chicken(int x, int y){
        int min = Integer.MAX_VALUE;
        for(Location store: stores){
            int thisdistance = Math.abs(store.x -x)+Math.abs(store.y-y);
            min = Math.min(min,thisdistance);
        }
        return min;
    }
    public static void dfs(int x, int y, int m ,int[][] city){
        if(m == 0){
            int citydistance = 0;
            for(int i = 0; i<n;i++){
                for(int j = 0; j<n;j++){
                    if(city[i][j] == house){
                        citydistance+=chicken(i,j);
                    }
                }
            }
            min = Math.min(min, citydistance);
            return;
        }
        for(int i = x; i<n;i++){
            if(i!=x) y =0;
            for(int j = y; j<n;j++){
                if(city[i][j]==store){
                    Location build = new Location(i,j);
                    stores.add(build);
                    dfs(i,j+1,m-1,city);
                    stores.remove(build);
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
