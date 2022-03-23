import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        t = Integer.parseInt(first);
      for(int i = 0; i<t;i++){
          String next= br.readLine();
          String[] each = next.split(" ");
          int m = Integer.parseInt(each[0]);
          int n = Integer.parseInt(each[1]);
          int x = Integer.parseInt(each[2]);
          int y = Integer.parseInt(each[3]);
          int gcd = gcd(m,n);
          int j = 0;
          boolean find = false;
          while(m*j<m*n/gcd){
              if((m*j+x-y)%n==0){
                  sb.append(Integer.toString(m*j+x)+"\n");
                  find = true;
                  break;
              }
              j++;
          }
          if(!find){
              sb.append(-1+"\n");
          }
      }
        System.out.println(sb.toString());
    }
    public static int gcd(int x, int y){
        while(y!=0){
            int r = x%y;
            x = y;
            y = r;
        }
        return x;
    }
}
