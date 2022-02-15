import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;

    public static void main(String[] args) throws IOException {

        while(true) {
            String input = br.readLine();
            if(input == null) return;
            k = Integer.parseInt(input);
            int num = 1;
            int count = 1;
            while(true){
                if(num%k == 0) {System.out.println(count); break;}
                num = (num%k)*10+1;
                count++;
            }
        }
    }



}
