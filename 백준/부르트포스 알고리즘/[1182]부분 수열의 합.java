import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] number;
    static int s;
    static int temps;
    static int count = 0;
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오고 초기 area 상태 설정, 가장 낮은 높이&가장높은 높이 구하기
        String input = br.readLine();
        String[] first = input.split(" ");
        n = Integer.parseInt(first[0]);
        s = Integer.parseInt(first[1]);
        number = new int[n];
        String next = br.readLine();
        String[] numbers = next.split(" ");
        for(int i = 0; i<n;i++){
            number[i] = Integer.parseInt(numbers[i]);
        }

        for(int i = 1;i<=n;i++){
            dfs(0,i);
        }
        System.out.println(count);
        }

        public static void dfs(int start, int r){
        if(r==0){
            if(temps == s) count++;
            return;
        }
        for(int i = start; i<n;i++){
            temps+=number[i];
            dfs(i+1,r-1);
            temps-=number[i];
        }
        }

    }
