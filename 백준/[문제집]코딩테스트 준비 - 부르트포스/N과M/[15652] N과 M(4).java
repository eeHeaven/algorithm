import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        String[] inputs = first.split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        dfs(0,new int[m]);

    }
    public static void dfs(int count, int[] result){
        if(count == m){
            printArray(result);
            return;
        }
        for(int i = 1; i<=n;i++){
            if(count>0){
                if(result[count-1]>i)continue;
            }
            result[count] = i;
            dfs(count+1,result);
        }
    }
    public static void printArray(int[] result){
        StringBuilder sb = new StringBuilder();
        for(int each: result){
            sb.append(Integer.toString(each)+" ");
        }
        System.out.println(sb.toString().substring(0,sb.length()-1));
    }
}
