import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Stack<Integer> st = new Stack<>();
        int orders = Integer.parseInt(br.readLine());
        for(int i = 0; i<orders; i++){
            int num = 0;
            String key = br.readLine();
            if(key.contains("push")){
                String[] pushs = key.split(" ");
                num = Integer.parseInt(pushs[1]);
                key = "push";
            }
            switch(key){
                case "push":
                    st.push(num);
                    break;
                case "pop":
                    if(st.isEmpty()) System.out.println(-1);
                    else
                        System.out.println(st.pop()); 
                     break;
                case "size":
                    System.out.println(st.size());
                    break;
                case "empty":
                    if(st.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top":
                    if(st.isEmpty()) System.out.println(-1);
                    else System.out.println(st.peek());
                    break;


            }
        }
    }
    }
