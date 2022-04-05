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
    static int[] num;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
      String NM = br.readLine();
      String[] nm = NM.split(" ");
      n = Integer.parseInt(nm[0]);
      m = Integer.parseInt(nm[1]);
      num = new int[n];
      temp = new int[m];
      String next =br.readLine();
      String[] each = next.split(" ");
      for(int i = 0; i<n;i++){
          num[i] = Integer.parseInt(each[i]);
      }
      Arrays.sort(num);
      combination(0,0);
        System.out.println(sb.toString());

    }
    public static void combination(int count, int start){
        if(count == m){
            for(int i = 0; i<m;i++){
                sb.append(temp[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i<n;i++){
            temp[count] = num[i];
            combination(count+1,i+1);
        }
    }
}
