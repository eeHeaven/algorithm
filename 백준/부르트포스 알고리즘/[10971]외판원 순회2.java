import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[][] W;
  static int start;
  static int min = Integer.MAX_VALUE;
  static boolean visit[];

    public static void main(String[] args) throws IOException {

        //초기 input값 가져오기
        String input = br.readLine();
        n = Integer.parseInt(input);
        W = new int[n][n];
        visit = new boolean[n];
        for(int i = 0; i<n;i++){
            String next = br.readLine();
            String each[] = next.split(" ");
            for(int j = 0; j<n;j++){
                W[i][j] = Integer.parseInt(each[j]);
            }
        }

        for(int i = 0; i<n;i++){
            start = i;
            visit[i] = true;
            dfs(0,i,1);
        }
        System.out.println(min);


    }
    public static void dfs(int cost, int departure, int count){
        if(count == n){
            if(W[departure][start]!=0){
                cost+=W[departure][start];
                min = Math.min(min,cost);
            }
            return;
        }
        for(int i = 0; i<n;i++){
            if(visit[i] == false && W[departure][i]!= 0){
                visit[i] = true;
                dfs(cost+W[departure][i],i,count+1);
                visit[i] = false;
            }
        }
    }
     }
