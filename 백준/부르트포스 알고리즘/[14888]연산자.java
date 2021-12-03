import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static int max = Integer.MIN_VALUE;
    public static int min = 1000000000;
    public static int[] numbers;
    public static int[] psmd;
    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        n = Integer.parseInt(input);
       String next = br.readLine();
       String next2 = br.readLine();
       String[] numbersS = next.split(" ");
       String[] K = next2.split(" ");
       numbers = new int[n];
       int i = 0;
       for(String N: numbersS){
           numbers[i++] = Integer.parseInt(N);
       }
       psmd = new int[4];
       i = 0;
       for(String k: K){
           psmd[i++] = Integer.parseInt(k);
       }
       combination(numbers[0],1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void combination(int num, int index) {
        if (index == n) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(psmd[i]>0){
                psmd[i] --;
                switch (i){
                    case 0: combination(num+numbers[index],index+1); break;
                    case 1: combination(num-numbers[index],index+1); break;
                    case 2: combination(num*numbers[index],index+1); break;
                    case 3: combination(num/numbers[index],index+1); break;
                }
                psmd[i] ++;
            }
        }

    }

}
