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
        String first = br.readLine();
        n = Integer.parseInt(first);
        String next = br.readLine();
        String[] each = next.split(" ");
        P = new int[n+1];
        dp = new int[n+1];
      for(int i = 1; i<=n;i++){
          P[i] = Integer.parseInt(each[i-1]);
              }
      dp[1] = P[1];
      dp[2] = Math.max(P[2],P[1]+P[1]);
        System.out.println(dp(n));
    }
    public static int dp(int n){
        if(dp[n]>0) return dp[n];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<=n/2;i++){
            max = Math.max(dp(i)+dp(n-i),max);
        }
        max = Math.max(max,P[n]);
        dp[n] = max;
        return dp[n];
    }
}
