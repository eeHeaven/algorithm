import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = 0;
        String inputs = br.readLine();
        int inputNum = Integer.parseInt(inputs);
        for(int i = 1; i<=inputNum;i++){
            String key = br.readLine();
            Stack<Character> s = new Stack<>();
            s.push('!');
            count++;
            for(int j = 0; j<key.length();j++){
                if(s.peek() == key.charAt(j)) continue;
                else{
                    if(s.contains(key.charAt(j))) {count--; break;}
                    s.push(key.charAt(j));
                }
            }
        }
        System.out.println(count);
    }
    }
