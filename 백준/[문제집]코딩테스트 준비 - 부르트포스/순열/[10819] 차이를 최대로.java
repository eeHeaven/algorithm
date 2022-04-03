import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visit;
    static int[] input;
    static int[] A;
    static int n;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        String N = br.readLine();
        n = Integer.parseInt(N);
        visit = new boolean[n];
        input = new int[n];
        A = new int[n];
        String next = br.readLine();
        String[] each = next.split(" ");
        for(int i = 0; i<n;i++){
            input[i] = Integer.parseInt(each[i]);
        }
        dfs(0);
        System.out.println(max);

    }
    public static void dfs(int start){
        if(start == n){
            int temp =0;
            for(int i = 0; i<n-1;i++){
                temp+=Math.abs(A[i]-A[i+1]);
            }
            max = Math.max(max,temp);
            return;
        }
     for(int i = 0; i<n;i++){
         if(visit[i] == false){
             visit[i] = true;
             A[start] = input[i];
             dfs(start+1);
             visit[i] = false;
         }
     }
    }
}
