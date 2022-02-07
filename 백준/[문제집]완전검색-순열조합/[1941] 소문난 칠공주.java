import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] entire = new char[5][5];
    static int[] student = new int[25];
    static int count = 0;

    public static void main(String[] args) throws IOException {
      for(int i = 0; i<5;i++){
          String line = br.readLine();
          for(int j = 0; j<5;j++){
             entire[i][j] = line.charAt(j);
          }
      }

      for(int i = 0; i<25;i++) student[i] = i;

      combination(new ArrayList<Integer>(),0,0);
      System.out.println(count);
    }
    public static void combination(ArrayList<Integer> girls, int start, int girlcount){
        if(girlcount == 7){
            if(countS(girls)>=4) count++;
            return;
        }
        for(int i = start; i<student.length;i++){
            girls.add(student[i]);
            combination(girls,i+1,girlcount+1);
            girls.remove((Integer)student[i]);
        }
    }

    public static boolean isNext(int girl1, int girl2){
        if((girl1/5 == girl2/5)&&((girl2%5 == girl1%5+1)||(girl2%5 == girl1%5-1))) return true;
        if((girl1%5 == girl2%5)&&((girl2/5 == girl1/5+1)||(girl2/5 == girl1/5-1))) return true;
        return false;
    }

    public static int countS(ArrayList<Integer> girls){
        int scount = 0;
        int left = 7;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(girls.get(0));
        ArrayList<Integer> temp = new ArrayList<>();
        for(int girl: girls){
            temp.add(girl);
        }
        temp.remove(0);
        left --;
        while(!queue.isEmpty()){
            int girl1 = queue.poll();
            if(entire[girl1/5][girl1%5] == 'S') scount++;
            for(int girl2: temp){
                if(girl2 == -1) continue;
                if(isNext(girl1,girl2)){
                    queue.add(girl2);
                    temp.set(temp.indexOf(girl2),-1);
                    left --;
                }
            }
        }
        if(left == 0) return scount;
        else return -1;
    }
}
