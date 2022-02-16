import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
   static int[] dp;

    public static void main(String[] args) throws IOException {

       String input = br.readLine();
      n = Integer.parseInt(input);
      dp = new int[n+1];
      dp[1] = 1;
      if(n>=2)dp[2] = 2;

      for(int i = 3; i<=n;i++) {
          if(i>n) {
              System.out.println(dp[n]); return;}
          dp[i] = (dp[i-1]+dp[i-2])%10007;
      }
        System.out.println(dp[n]);
    }
}
