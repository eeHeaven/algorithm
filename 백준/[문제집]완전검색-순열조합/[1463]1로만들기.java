import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        String inputnumber = br.readLine();
        k = Integer.parseInt(inputnumber);

        dp = new Integer[1000001];// dp[n] 은 n을 1로 만드는데 걸리는 최소 횟수
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        System.out.println(dfs(k));
    }

    public static int dfs(int n){
        if(dp[n] == null){
            if(n%6==0){
                 dp[n] = Math.min(dfs(n/3),Math.min(dfs(n/2),dfs(n-1)))+1;
            }
            else if(n%3 == 0) dp[n] = Math.min(dfs(n/3),dfs(n-1))+1;
            else if(n%2 == 0)  dp[n] = Math.min(dfs(n/2),dfs(n-1))+1;
            else dp[n] = dfs(n-1)+1;
        }
        return dp[n];
    }
}
