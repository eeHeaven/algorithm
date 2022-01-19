import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        //초기 input값 가져오기
        while(true){
        String input = br.readLine();
        String[] inputs = input.split(" ");
        if(inputs[0].equals("0")) return;
        int k = Integer.parseInt(inputs[0]);
        String[] numbers = new String[k];
        for(int i = 0; i<k;i++){
            numbers[i] = inputs[i+1];
        }

        dfs(0,numbers,0,"");
            System.out.println("");

       }



    }

    public static void dfs(int start, String[] numbers, int count, String lotto){
        if(count == 6){
            System.out.println(lotto);
            return;
        }
        for(int i = start; i<numbers.length;i++){
            if(count == 0) dfs(i+1, numbers, count+1,lotto+numbers[i]);
            else dfs(i+1,numbers,count+1,lotto+" "+numbers[i]);
        }
    }
     }
