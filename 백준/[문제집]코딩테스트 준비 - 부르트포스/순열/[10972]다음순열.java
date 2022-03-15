import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] num;


    public static void main(String[] args) throws IOException{
        String first = br.readLine();
        n =  Integer.parseInt(first);
        String k = br.readLine();
        String[] ks = k.split(" ");
        num= new int[n];
       for(int i = 0; i<n;i++) num[i] = Integer.parseInt(ks[i]);

       int swapPoint = -1;
       for(int i = n-1; i>=1;i--){
           if(num[i]>num[i-1]){
               swapPoint = i-1;
               break;
           }
       }
       if(swapPoint == -1) {
           System.out.println(-1); return;}

       for(int j = n-1; j>=0;j--){
           if(num[j]>num[swapPoint]){
               //둘을 swap 하기
               int temp = num[swapPoint];
               num[swapPoint] = num[j];
               num[j] = temp;
               break;
           }
       }
       Arrays.sort(num,swapPoint+1,num.length);
       for(int i = 0; i< num.length;i++){
           System.out.print(num[i]+" ");
       }
    }
}
