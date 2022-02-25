import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

       String input = br.readLine();
       String[] inputs = input.split(" ");
       n = Integer.parseInt(inputs[0]);
       m = Integer.parseInt(inputs[1]);

       dfs(0,"",new boolean[n+1]);
    }

    public static void dfs(int count, String result, boolean[] visited){
        if(count == m){
            System.out.println(result);
            return;
        }
        for(int i = 1; i<=n;i++){
            if(visited[i] == false){
                visited[i] = true;
                if(count == 0) dfs(count+1,Integer.toString(i),visited);
                else dfs(count+1,result+" "+Integer.toString(i),visited);
                visited[i] = false;
            }
        }
    }



}
