import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int dp[][]; //dp[n][k] = n자리 오르막수 중 가장 앞의 자리가 k인 수의 개수


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        n = Integer.parseInt(first);
        dp =new int[n+1][10];
        for(int i = 0; i<10;i++) dp[1][i] = 1;
       dp(n,0);
       int result = 0;
       for(int i =0;i<10;i++){
           result=(result+dp[n][i])%10007;
       }
        System.out.println(result);

    }

    public static int dp(int n,int k){
       if(dp[n][k] >0) return dp[n][k];
       for(int i = 0; i<=9;i++){
           for(int j = i; j<=9;j++){
               dp[n][i] =(dp[n][i] +dp(n-1,j))%10007;
           }
       }
       return dp[n][k];
    }
}
