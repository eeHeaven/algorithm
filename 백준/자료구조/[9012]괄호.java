import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i<num;i++){
            int pair = 1;
            String input = br.readLine();
            if(input.charAt(0) == ')') {System.out.println("NO"); continue;}
            char previous = '(';
            char current;
            for(int j = 1; j<input.length();j++){
                current = input.charAt(j);
                if(previous == '('){
                    if(current == '(') pair++;
                    else pair --;
                }
                else{if(current =='(') pair++; else pair--;}
                previous = current;
                if(pair<0) break;

            }
            if(pair == 0) System.out.println("YES");
            else System.out.println("NO");
        }

            }
        }
