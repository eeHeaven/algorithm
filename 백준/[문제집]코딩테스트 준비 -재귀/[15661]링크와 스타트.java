import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] s;
    static boolean[] member;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        n = Integer.parseInt(first);
        s = new int[n][n];
        member = new boolean[n];

        for(int i = 0; i<n;i++){
            String next= br.readLine();
            String[] each = next.split(" ");
            for(int j = 0; j<n;j++){
               s[i][j] = Integer.parseInt(each[j]);
            }
        }

        maketeam(0);
        System.out.println(min);

    }

    public static void maketeam(int depth){
        if(depth == n){
            teamskill();
            return;
        }
        member[depth] = true;
        maketeam(depth+1);
        member[depth] = false;
        maketeam(depth+1);
    }

    public static void teamskill(){
        int start = 0;
        int link = 0;
        for(int i = 0; i<n;i++){
            for(int j = i+1;j<n;j++){
                if(member[i] == member[j]){
                    if(member[i] == true)
                        start += s[i][j]+s[j][i];
                    else link += s[i][j] + s[j][i];
                }
            }
        }
        int diff = Math.abs(start-link);
        min = Math.min(diff,min);
    }
}
