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
        String first = br.readLine();
        n = Integer.parseInt(first);
        dp = new int[100001];
        dp[0] = 1;
        dp[1] = 3;
        if(n<=1) {
            System.out.println(dp[n]);
            return;
        }
        System.out.println(dp(n));

    }
    public static int dp(int n){
        if(dp[n]>0) return dp[n];
        int first = dp(n-1);
        int second = dp(n-2);
       dp[n] = (first*3 -(first-second))%9901;
       return dp[n];
    }
}
