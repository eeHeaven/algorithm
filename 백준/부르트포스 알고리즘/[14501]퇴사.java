import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int max = Integer.MIN_VALUE;
    public static int[] time;
    public static int[] pay;
    public static int totalP =0;
    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        int n = Integer.parseInt(input);
        time = new int[n+1]; //index 0 은 안씀
        pay = new int[n+1];
        for(int i = 0; i<n;i++){
            String work = br.readLine();
            String[] TP = work.split(" ");
            time[i+1] = Integer.parseInt(TP[0]);
            pay[i+1] = Integer.parseInt(TP[1]);
        }
        dfs(1,n);
        System.out.println(max);
    }

    public static void dfs(int start, int n){
        if(start>n){
            max = Math.max(max,totalP);
            return;
        }
        for(int i = start; i<=n; i++){
            if (work(i,n)){ // 일할 수 있음
                totalP += pay[i]; // 일하고 페이받기
                dfs(i+time[i],n); //다음 일 가능한 날짜로 이동
                totalP -= pay[i]; // 재귀 끝나면 일 페이 다시 돌려놓기
            }
            else if(i == n && work(i,n)==false)  max = Math.max(max,totalP);
        }
    }

    public static boolean work(int day, int n ){
        if(time[day]-1+day>n) return false;
        return true;
    }

}
