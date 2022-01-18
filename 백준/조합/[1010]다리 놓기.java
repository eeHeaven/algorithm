import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int h;
  static StringBuilder sb = new StringBuilder();
  static int[][] cases;
  static int[][] dp = new int[30][30];
  static int casecount;

    public static void main(String[] args) throws IOException {

        //초기 input값 가져오기
        String input = br.readLine();
        h = Integer.parseInt(input);
        StringTokenizer st;
       for(int i = 0; i<h;i++){
           st = new StringTokenizer(br.readLine()," ");
           int n = Integer.parseInt(st.nextToken());
           int m = Integer.parseInt(st.nextToken());
           sb.append(combination(m,n)).append("\n");
       }
        System.out.println(sb);

    }

    public static int combination(int n, int m){
       if(dp[n][m]>0){
           return dp[n][m];
       }
       if(n==m||m==0){
           return dp[n][m] = 1;
       }
       return dp[n][m] = combination(n-1,m-1)+combination(n-1,m);
    }
     }
