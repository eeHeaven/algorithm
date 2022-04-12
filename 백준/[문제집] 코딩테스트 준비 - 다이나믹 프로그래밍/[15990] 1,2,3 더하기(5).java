import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long[][] dp;
    static int T;
    public static void main(String[] args) throws Exception {
        String t = br.readLine();
        T = Integer.parseInt(t);
        dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int j = 4;j<=100000;j++){
            dp[j][1] = (dp[j-1][2]+dp[j-1][3])%1000000009;
            dp[j][2] = (dp[j-2][1]+dp[j-2][3])%1000000009;
            dp[j][3] = (dp[j-3][2]+dp[j-3][1])%1000000009;
        }
        for(int i = 0; i<T;i++){
            String next = br.readLine();
            int n = Integer.parseInt(next);
            long result = (dp[n][1]+dp[n][2]+dp[n][3])%1000000009;
            sb.append(result+"\n");
        }
        System.out.println(sb.toString());
    }

}
