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

    public static void main(String[] args) throws Exception {

      String N  =br.readLine();
      n = Integer.parseInt(N);
        String next = br.readLine();
        String[] each = next.split(" ");
        dp = new int[n]; //n번째 인덱스까지 모두 더한 합
        for(int i =0 ; i<n;i++){
            if(i == 0) dp[i] = Integer.parseInt(each[0]);
            else dp[i] = dp[i-1]+Integer.parseInt(each[i]);
        }
        int min = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n;i++){
            if(dp[i]<0) {
                if(dp[i]-min<min) { max = Math.max(max,dp[i]);}
                else {max = Math.max(max,dp[i]-min);}
                min = Math.min(min, dp[i]);
                continue;
            }
            max = Math.max(max,dp[i]-min);
        }
        System.out.println(max);
    }
}
