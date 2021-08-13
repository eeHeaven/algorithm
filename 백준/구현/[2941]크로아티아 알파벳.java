import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String key = br.readLine();
        int count = 0;
        for(int i = 0; i<key.length();i++){
            if(i+1<key.length()&&key.charAt(i)=='c'){
                if(key.charAt(i+1) =='='||key.charAt(i+1) =='-')
                {count++;
                i++;
                    continue;}
            }
            if(i+1<key.length()&&key.charAt(i)=='d'){
                if(i+2<key.length()&&key.charAt(i+1) =='z'&&key.charAt(i+2)=='=') i= i+2;
                else if(key.charAt(i+1) =='-') i++;
                count++;
                continue;
        }
            if(i+1<key.length()&&key.charAt(i)=='l'&&key.charAt(i+1)=='j'){
                i++;
                count++;
                continue;
            }
            if(i+1<key.length()&&key.charAt(i)=='n'&&key.charAt(i+1)=='j'){
                i++;
                count++;
                continue;
            }
            if(i+1<key.length()&&key.charAt(i)=='s'&&key.charAt(i+1)=='='){
                i++;
                count++;
                continue;
            }
            if(i+1<key.length()&&key.charAt(i)=='z'&&key.charAt(i+1)=='='){
                i++;
                count++;
                continue;
            }
            count++;
    }
        System.out.println(count);
}}
