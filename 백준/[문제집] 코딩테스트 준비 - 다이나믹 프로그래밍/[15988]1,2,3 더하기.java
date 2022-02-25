import java.io.*;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] dp = new long[1000001];
    static int n;
    static long D = 1000000009;


    public static void main(String[] args) throws Exception {

        String input = br.readLine();
        int count = Integer.parseInt(input);
        dp[1] =1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 0;i<count;i++){
            String next = br.readLine();
            n= Integer.parseInt(next);
            //계산실행
            System.out.println(dp(n));
        }

    }
    public static long dp(int n){
       if(dp[n]> 0) return dp[n];
        else return dp[n] = (dp(n-3)%D+dp(n-2)%D+dp(n-1)%D)%D;
    }
}
