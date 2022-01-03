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
    static int[] calculate = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max= Integer.MIN_VALUE;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오고 초기 area 상태 설정, 가장 낮은 높이&가장높은 높이 구하기
        String input = br.readLine();
        n = Integer.parseInt(input);
        String next = br.readLine();
        String[] second = next.split(" ");
        number = new int[n];
        for(int i = 0; i<n;i++){
            number[i] = Integer.parseInt(second[i]);
        }
        String next2 = br.readLine();
        String[] third = next2.split(" ");
        for(int i = 0; i<4;i++){
            calculate[i] = Integer.parseInt(third[i]);
        }
        result = number[0];
        dfs(0, calculate,new int[n-1]);
        System.out.println(max);
        System.out.println(min);


        }

        public static void dfs(int count, int[] calculate,int[] tempcal){

        if(count == n-1){
            result = number[0];
            for(int j = 0 ; j<n-1;j++){
                switch (tempcal[j]){
                    case 0:
                        result+=number[j+1];
                        break;
                    case 1:
                        result-=number[j+1];
                        break;
                    case 2:
                        result*=number[j+1];
                        break;
                    case 3:
                        result = result/number[j+1];
                        break;
                }
            }
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for(int i =0; i<4;i++){
            if(calculate[i] == 0) continue;
            calculate[i] --;
           tempcal[count] = i;
            dfs(count+1,calculate,tempcal);
            calculate[i] ++;

        }
        }

    }
