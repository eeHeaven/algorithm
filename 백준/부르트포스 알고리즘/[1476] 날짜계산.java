import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static int e;
   static int s;
   static int m;
   static int result = 1;
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오고 초기 area 상태 설정, 가장 낮은 높이&가장높은 높이 구하기
        String input = br.readLine();
       String[] esm = input.split(" ");
        e = Integer.parseInt(esm[0]);
        s = Integer.parseInt(esm[1]);
        m = Integer.parseInt(esm[2]);

        int earth = 1, moon = 1, sun =1;
        while(true){
            if(e==earth&&m==moon&&sun==s) break;
           earth =  earth(earth);
           moon = moon(moon);
           sun= sun(sun);
           result++;
        }
        System.out.println(result);
        }

        public static int earth(int earth){
        earth++;
        if(earth == 16) earth = 1;
        return earth;
        }
    public static int moon(int moon){
        moon++;
        if(moon == 20) moon = 1;
        return moon;
    }
    public static int sun(int sun){
        sun++;
        if( sun== 29) sun = 1;
        return sun;
    }

    }
