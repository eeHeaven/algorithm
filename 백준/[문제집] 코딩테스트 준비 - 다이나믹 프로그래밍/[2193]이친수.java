import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long[][]dp = new long[91][2];

    public static void main(String[] args) throws Exception {

      String N  =br.readLine();
      n = Integer.parseInt(N);

      dp[1][1] = 1;
      for(int i = 2;i<=90;i++){
          dp[i][0] = dp[i-1][1]+dp[i-1][0];
          dp[i][1] = dp[i-1][0];
      }

        System.out.println(dp[n][0]+dp[n][1]);
    }
}
