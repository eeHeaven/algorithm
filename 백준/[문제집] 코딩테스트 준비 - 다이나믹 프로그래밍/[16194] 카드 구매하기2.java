import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
      String N = br.readLine();
      n = Integer.parseInt(N);
      P = new int[n+1];
      dp = new int[n+1];
      String next = br.readLine();
      String[] each  = next.split(" ");
      for(int i = 0; i<each.length;i++){
          P[i+1] =Integer.parseInt(each[i]);
      }
        System.out.println(dp(n));

    }
    public static int dp(int n ){
        if(dp[n]>0) return dp[n];
        dp[n] = Integer.MAX_VALUE;
        for(int i =1; i<=n/2;i++){
            dp[n] = Math.min(dp[n],dp(i)+dp(n-i));
        }
        dp[n] = Math.min(dp[n],P[n]);
        return dp[n];
    }
}
