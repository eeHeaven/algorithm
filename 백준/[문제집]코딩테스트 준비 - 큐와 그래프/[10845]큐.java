import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
   static ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String[] args) throws IOException {

       String input = br.readLine();
      n = Integer.parseInt(input);
      for(int i =0; i<n;i++){
          String eachline = br.readLine();
          if(eachline.contains("push")){
              String[] push = eachline.split(" ");
              int num = Integer.parseInt(push[1]);
              queue.add(num);
          }
          else if(eachline.contains("pop")){
              if(queue.isEmpty()) System.out.println("-1");
              else System.out.println(queue.remove(0));

          }
          else if(eachline.contains("size")){
              System.out.println(queue.size());
          }
          else if(eachline.contains("empty")){
              if(queue.isEmpty()) System.out.println("1");
              else System.out.println("0");
          }
          else if(eachline.contains("front")){
              if(queue.isEmpty()) System.out.println("-1");
              else System.out.println(queue.get(0));
          }
          else{
              if(queue.isEmpty()) System.out.println("-1");
              else System.out.println(queue.get(queue.size()-1));
          }
      }
    }


}
