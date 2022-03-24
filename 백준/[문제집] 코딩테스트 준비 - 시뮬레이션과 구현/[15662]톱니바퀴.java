import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static boolean[][] saw;
    static boolean[] spin;
    static boolean[] visit;
    static int K;


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        T = Integer.parseInt(first);
        saw = new boolean[T+1][8];
        for(int i = 0; i<T;i++){
            String each = br.readLine();
            for(int j = 0; j<8;j++){
                if(each.charAt(j)=='1') saw[i+1][j] = true;
                else saw[i+1][j] = false;
            }
        }
        String next = br.readLine();
        K = Integer.parseInt(next);
        for(int i = 0; i<K;i++){
            String order = br.readLine();
            String eachorder[] = order.split(" ");
            spin = new boolean[T+1];
            visit = new boolean[T+1];
            visit[Integer.parseInt(eachorder[0])] = true;
            boolean dir;
            String direction = eachorder[1];
            if(direction.equals("1")){
                dir = true;
            }
            else{ dir = false;}
            spin[Integer.parseInt(eachorder[0])] = dir;
            checktospin(Integer.parseInt(eachorder[0]),dir);
            entirespin();
        }
        int count = 0;
        for(int i = 1;i<=T;i++){
            if(saw[i][0] == true) count++;
        }
        System.out.println(count);
    }
    public static void checktospin(int n, boolean dir){
        if(n>1&&n<T){
            if(saw[n-1][2]!=saw[n][6] && visit[n-1]== false){
                visit[n-1] = true;
                spin[n-1] = !dir;
                checktospin(n-1,!dir);
            }
            if(saw[n+1][6]!=saw[n][2] && visit[n+1]== false){
                visit[n+1] = true;
                spin[n+1] = !dir;
                checktospin(n+1,!dir);
            }
        }
        else if(n ==1){
            if(saw[n+1][6]!=saw[n][2] && visit[n+1]== false){
                visit[n+1] = true;
                spin[n+1] = !dir;
                checktospin(n+1,!dir);
            }
        }
        else{
            if(saw[n-1][2]!=saw[n][6] && visit[n-1]== false){
                visit[n-1] = true;
                spin[n-1] = !dir;
                checktospin(n-1,!dir);
            }
    }
}
public static void entirespin(){
        for(int i = 1;i<=T;i++){
            if(visit[i] == true){
                if(spin[i] == true) sawspin(i);
                else reversespin(i);
            }
        }
}
public static void sawspin(int i ){
        boolean temp = saw[i][7];
        for(int j = 6;j>=0;j--){
            saw[i][j+1] = saw[i][j];
        }
        saw[i][0] = temp;
}
    public static void reversespin(int i ){
        boolean temp = saw[i][0];
        for(int j = 1;j<=7;j++){
            saw[i][j-1] = saw[i][j];
        }
        saw[i][7] = temp;
    }
}
