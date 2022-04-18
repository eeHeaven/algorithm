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
    static int[] arr;

    public static void main(String[] args) throws Exception {

      String N  =br.readLine();
      n = Integer.parseInt(N);
        String next = br.readLine();
        String[] each = next.split(" ");
        dp = new int[n]; //n번째 인덱스 기준 자기보다 작은 수들 중 가장 긴 증가수열의 길이
        arr = new int[n];
        for(int i =0 ; i<n;i++){
            int temp = Integer.parseInt(each[i]);
            arr[i] = temp;
            }
        int maxdp = 0;
        for(int i = 0; i<n;i++){
            if(i == 0) dp[0] = 0;
            else{
                if(arr[i]>arr[i-1]){
                    int max = 0;
                    for(int j = 0; j<i;j++){
                        if(arr[j] <arr[i]){
                            max = Math.max(dp[j],max);
                        }
                    }
                    dp[i] = max +1;
                }
                else if(arr[i] == arr[i-1]) dp[i] = dp[i-1];
                else{ //arr[i]<arr[i-1]
                    int max = 0;
                    int same = 0;
                    boolean flag = false;
                    for(int j =0;j<i-1;j++){
                        if(arr[i]>arr[j]){
                            max = Math.max(max,dp[j]);
                            flag = true;
                        }
                        else if(arr[i] == arr[j]) same = dp[j];
                    }
                    if(!flag){
                        if(same == 0)dp[i] = 0;
                        else dp[i] = same;
                    }
                    if(flag) dp[i] = max+1;
                }
            }
            maxdp = Math.max(maxdp,dp[i]);
        }
        System.out.println(maxdp+1);
    }
}
