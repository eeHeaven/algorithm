import java.io.*;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] num;
    static int n;
    static int m;



    public static void main(String[] args) throws Exception {

        String input = br.readLine();
        String[] nm = input.split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        num = new int[m];
        dfs(0);
        bw.flush();

    }
    public static void dfs(int count) throws Exception{
        if(count == m) {
            for(int i = 0;i<m;i++)bw.write(Integer.toString(num[i])+" ");
            bw.write("\n");
            return;
        }
        for(int i = 1; i<=n;i++){
            num[count] = i;
            dfs(count+1);
        }
    }
}
