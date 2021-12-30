import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오고 초기 board 상태 설정
        String input = br.readLine();
       int n= Integer.parseInt(input);
       
       int value = 666;
       int count = 0;
       while(count<n){
           String temp = Integer.toString(value);
           if(temp.contains("666")) count++;
           value++;
       }
        System.out.println(value-1);
    }
}
