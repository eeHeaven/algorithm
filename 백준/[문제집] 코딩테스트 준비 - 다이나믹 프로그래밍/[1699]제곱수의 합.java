import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws Exception {

      String N  =br.readLine();
      n = Integer.parseInt(N);
     int[] dp = new int[100001];
     dp[1] = 1;
     dp[2] =2;
     dp[3] = 3;
     ArrayList<Integer> square = new ArrayList<>();
      for(int i = 4;i<=100000;i++){
          if(Math.sqrt(i)%1 == 0){
              dp[i] = 1;
              square.add(i);
          }
          else{
              int min = Integer.MAX_VALUE;
              for(int value : square){
                  min = Math.min(min,dp[i-value]+1);
              }
              dp[i] = min;
          }
      }
        System.out.println(dp[n]);
    }
}
