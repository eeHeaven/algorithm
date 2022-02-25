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
        String[] nm = input.split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        
        combination(m,"",1);
        
    }
    public static void combination(int count, String result, int start){
        if(count == 0){
            System.out.println(result);
            return;
        }
        for(int i = start; i<=n;i++){
            if(count == m) combination(count-1,result+Integer.toString(i),i+1);
            else combination(count-1,result+" "+Integer.toString(i),i+1);
        }
    }
}
