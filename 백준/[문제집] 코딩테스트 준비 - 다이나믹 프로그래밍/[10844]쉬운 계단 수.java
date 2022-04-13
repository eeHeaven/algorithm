import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] dp = new int[101][10];

    public static void main(String[] args) throws Exception {

        String N = br.readLine();
        n = Integer.parseInt(N);

        for(int i = 1;i<=9;i++) dp[1][i] = 1;
        for(int i =2; i<=100;i++){
            dp[i][0] = dp[i-1][1];
            for(int j = 1;j<=8;j++){
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
            }
            dp[i][9] = dp[i-1][8];
        }
        int answer = 0;
        for(int i = 0;i<=9;i++){
            answer = (answer+dp[n][i])%1000000000;
        }
        System.out.println(answer);

    }
}
