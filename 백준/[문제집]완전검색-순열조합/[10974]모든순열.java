import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        n = Integer.parseInt(input);
        dfs(new boolean[n],"");
    }
    public static void dfs(boolean[] visit,String result){
        if(result.length() == n*2-1) {
            System.out.println(result);
        }
        for(int i = 0; i<n;i++){
            if(!visit[i]){
                visit[i] = true;
                if(result.length() ==0) dfs(visit, result+(i+1));
                else dfs(visit,result+" "+(i+1));
                visit[i] = false;
            }
        }
    }
}
