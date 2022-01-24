import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] numbers = {1,2,3};
    static int answer;

    public static void main(String[] args) throws IOException {
        String inputnumber = br.readLine();
        int k = Integer.parseInt(inputnumber);

        for(int j =0; j<k;j++){
        String input = br.readLine();
        n = Integer.parseInt(input);

        answer = 0;
        for(int i = 1; i<=n;i++){
            dfs(i,0);
        }
        System.out.println(answer);
    }}
    public static void dfs(int count, int result){
       if(count == 0){
           answer++;
       }
       for(int i = 0; i<3;i++){
           if(result+numbers[i] < n&& count!=1) dfs(count-1,result+numbers[i]);
           else if(result+numbers[i] == n && count ==1) dfs(count -1, result+numbers[i]);
       }
    }
}
