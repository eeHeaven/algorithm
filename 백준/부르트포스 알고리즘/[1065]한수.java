import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
    String number = br.readLine();
    int target = Integer.parseInt(number);
    int targetL = (int)(Math.log10(target)+1);
    if(targetL<=2){
        System.out.println(target);
        return;
    }
    int answer = 99;
    if(target == 1000) target = 999;
    answer+= sub(target,3);
    answer+= add(target,3);
        System.out.println(answer);


}

public static int sub(int target, int targetL){
        int firstnum = target /(int)(Math.pow(10,targetL-1));
        int count = 0;
        for(int k = 1;k<=firstnum;k++){
        for(int i = 1;i<=4;i++) {
            if (k - (i * (targetL - 1)) >= 0) {
                int tmp = 0;
                for (int j = 0; j <= targetL - 1; j++) {
                    tmp += (k - (i * j)) * (int) (Math.pow(10, targetL - 1 - j));
                }
                //      tmp+=firstnum-(i*(targetL-1));
                if (tmp <= target) count++;
            }
        }
        }
        return count;
}

    public static int add(int target, int targetL){
        int firstnum = target/(int)(Math.pow(10,targetL-1));
        int count = 0;
        for(int k = 1; k<=firstnum;k++){
        for(int i = 0;i<=4;i++){
            if(k + (i*(targetL-1))<=9){
                int tmp = 0;
                for(int j = 0; j<=targetL-1;j++){
                    tmp +=(k+(i*j))*(int)(Math.pow(10,targetL-1-j));
                }
               // tmp+=firstnum+(i*(targetL-1));
                if(tmp<=target) count++;
                else break;
            }}
        }
        return count;
    }


}
