import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        
        int count = 1; 
        int answer = 0;
        while(count<=n){
            int temp = count;
            while(temp>0){
                temp = temp/10;
                answer++;
            }
            count++;
        }
        System.out.println(answer);
    }
}
