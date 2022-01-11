import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int m;
  static int n;
  static int h;
  static int staticline;
   static boolean flag = false;
    static int[][] ladder;
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오기
        String input = br.readLine();
       String[] nmh = input.split(" ");
        n = Integer.parseInt(nmh[0]);
        m = Integer.parseInt(nmh[1]);
        h = Integer.parseInt(nmh[2]);
        if(m == 0) {
            System.out.println(0);
            return;
        }
        ladder = new int[h][n+1];
        for(int i = 0; i<m;i++){
            String each = br.readLine();
            String[] block = each.split(" ");
            for(int j = 0; j<2;j++){
                int a = Integer.parseInt(block[0]);
                int b = Integer.parseInt(block[1]);
                ladder[a-1][b] = 1;
            }
        }
        int count = 0;
       while(count<=3){
           addladder(count, ladder,0,1);
           if(flag == true) {
               System.out.println(count);
               return;
           }
           count++;
       }


        System.out.println(-1);
       return;

    }

    public static void eachline(int line, int step){
       if(step == h) {staticline =  line; return;}
       if(ladder[step][line-1]==1) eachline(line-1,step+1);
       else if(ladder[step][line]==1)eachline(line+1,step+1);
       else eachline(line, step+1);
    }
    public static boolean playgame(){
       for(int i = 1;i<=n;i++){
           staticline = 0;
           eachline(i,0);
           if(staticline!= i) return false;
        }
       return true;}

    public static void addladder(int step, int[][] ladder, int starti, int startj){
        if(step ==0){
            if(playgame()) flag = true;
             return;
        }
        for(int i = starti; i<h;i++){
            if(i !=starti) startj =1;
            for(int j = startj; j<=n-1;j++){
                if(ladder[i][j] == 0&&ladder[i][j-1]==0&&ladder[i][j+1]==0){
                    ladder[i][j] =1;
                    addladder(step-1,ladder,starti,startj+1);
                    ladder[i][j] =0;
                }
            }
        }
    }
     }
