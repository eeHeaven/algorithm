import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static String[] operation;
    static boolean stopflag = false;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        k = Integer.parseInt(input);
        String next = br.readLine();
        operation = next.split(" ");
        
        for(int i = 9; i>=0;i--){
            if(stopflag == true) break;
            boolean[] visited = new boolean[10];
            visited[i] = true;
            dfsmax(i,0,Integer.toString(i),visited);
        }
        stopflag = false;
        for(int i = 0; i<10;i++){
            if(stopflag == true) break;
            boolean[] visited = new boolean[10];
            visited[i] = true;
            dfsmin(i,0,Integer.toString(i),visited);
        }


    }

    public static void dfsmin(int prev,int index, String result,boolean[] visited){
        if(index == k){
            System.out.println(result);
            stopflag = true;
        }
        for(int i = 0;i<10;i++){
            if(stopflag == true) break;
            if((visited[i] == false)){
                switch(operation[index]){
                    case "<":
                        if(prev < i){
                            visited[i] = true;
                            dfsmin(i,index+1,result+Integer.toString(i),visited);
                            visited[i] = false;
                        }
                        break;
                    case ">":
                        if(prev > i){
                            visited[i] = true;
                            dfsmin(i,index+1,result+Integer.toString(i),visited);
                            visited[i] = false;
                        }
                        break;

                }
            }
        }
    }
    public static void dfsmax(int prev,int index, String result,boolean[] visited){
        if(index == k){
            System.out.println(result);
            stopflag = true;
        }
        for(int i = 9;i>=0;i--){
            if(stopflag == true) break;
            if((visited[i] == false)){
                switch(operation[index]){
                    case "<":
                        if(prev < i){
                            visited[i] = true;
                            dfsmax(i,index+1,result+Integer.toString(i),visited);
                            visited[i] = false;
                        }
                        break;
                    case ">":
                        if(prev > i){
                            visited[i] = true;
                            dfsmax(i,index+1,result+Integer.toString(i),visited);
                            visited[i] = false;
                        }
                        break;

                }
            }
        }
    }

}
