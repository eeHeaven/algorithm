import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        Queue<String> q = new LinkedList<>();
        int index = 1;
        for(int i = 0; i<num;i++){
            int key = Integer.parseInt(br.readLine());
            while(index<=key)
                {s.push(index++); q.add("+");}
            if(s.peek() == key){
                s.pop();
                q.add("-");
            }
                else {System.out.println("NO"); return;}
            }

        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
        }

            }
