import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int max = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오고 초기 board 상태 설정
        String input = br.readLine();
       int n= Integer.parseInt(input);
       int[][] board = new int[n][n];
       for(int i = 0; i<n;i++){
           String line = br.readLine();
           String[] each = line.split(" ");
           for(int j = 0 ;j<n;j++){
               board[i][j] = Integer.parseInt(each[j]);
           }
       }
       String print ="";
      dfs(board,0,n,print);
       System.out.println(max);
}

    public static int[][] moveleft(int[][] board, int n ){
        Stack<Integer> eachrow = new Stack<>();
        for(int i = 0; i<n;i++){
            Queue<Integer> queuerow = new LinkedList<>();
            for(int j = 0; j<n;j++){
                if(board[i][j] !=0){
                int thisnum = board[i][j];
                if(!eachrow.isEmpty()){
                    if(eachrow.peek() == thisnum){
                        eachrow.pop();
                        queuerow.add(thisnum*2);
                    }
                    else{
                        queuerow.add(eachrow.pop());
                        eachrow.push(thisnum);// 마지막 값이 아니면 stack에 넣기
                    }
                }
                else eachrow.push(thisnum);
            }} if(!eachrow.isEmpty()) queuerow.add(eachrow.pop());

            int index =0;
            while(!queuerow.isEmpty()){
                board[i][index++] = queuerow.poll();
            }
            while(index<n){
                board[i][index++] = 0;
            }
        }
        return board;
    }
    public static int[][] moveright(int[][] board, int n ){
        Stack<Integer> eachrow = new Stack<>();
        for(int i = 0; i<n;i++){
            Queue<Integer> queuerow = new LinkedList<>();
            for(int j = n-1; j>=0;j--){
                if(board[i][j] !=0){
                    int thisnum = board[i][j];
                    if(!eachrow.isEmpty()){
                        if(eachrow.peek() == thisnum){
                            eachrow.pop();
                            queuerow.add(thisnum*2);
                        }
                        else{
                            queuerow.add(eachrow.pop());
                            eachrow.push(thisnum);// 마지막 값이 아니면 stack에 넣기
                        }
                    }
                    else eachrow.push(thisnum);
                }} if(!eachrow.isEmpty()) queuerow.add(eachrow.pop());

            int index =n-1;
            while(!queuerow.isEmpty()){
                board[i][index--] = queuerow.poll();
            }
            while(index>=0){
                board[i][index--] = 0;
            }
        }
        return board;
    }
    public static int[][] moveup(int[][] board, int n ){
        Stack<Integer> eachrow = new Stack<>();
        for(int i = 0; i<n;i++){
            Queue<Integer> queuerow = new LinkedList<>();
            for(int j = 0; j<n;j++){
                if(board[j][i] !=0){
                    int thisnum = board[j][i];
                    if(!eachrow.isEmpty()){
                        if(eachrow.peek() == thisnum){
                            eachrow.pop();
                            queuerow.add(thisnum*2);
                        }
                        else{
                            queuerow.add(eachrow.pop());
                            eachrow.push(thisnum);// 마지막 값이 아니면 stack에 넣기
                        }
                    }
                    else eachrow.push(thisnum);
                }} if(!eachrow.isEmpty()) queuerow.add(eachrow.pop());

            int index =0;
            while(!queuerow.isEmpty()){
                board[index++][i] = queuerow.poll();
            }
            while(index<n){
                board[index++][i] = 0;
            }
        }
        return board;
    }
    public static int[][] movedown(int[][] board, int n ){
        Stack<Integer> eachrow = new Stack<>();
        for(int i = 0; i<n;i++){
            Queue<Integer> queuerow = new LinkedList<>();
            for(int j = n-1; j>=0;j--){
                if(board[j][i] !=0){
                    int thisnum = board[j][i];
                    if(!eachrow.isEmpty()){
                        if(eachrow.peek() == thisnum){
                            eachrow.pop();
                            queuerow.add(thisnum*2);
                        }
                        else{
                            queuerow.add(eachrow.pop());
                            eachrow.push(thisnum);// 마지막 값이 아니면 stack에 넣기
                        }
                    }
                    else eachrow.push(thisnum);
                }} if(!eachrow.isEmpty()) queuerow.add(eachrow.pop());

            int index =n-1;
            while(!queuerow.isEmpty()){
                board[index--][i] = queuerow.poll();
            }
            while(index>=0){
                board[index--][i] = 0;
            }
        }
        return board;
    }
    public static void dfs(int[][] board, int count,int n,String print){
        if(count == 5){
           max = Math.max(max,findMax(board));
            System.out.println(print);
            return;
        }
        int[][] temp = new int[n][n];
        for(int i =0; i<n;i++){
            for(int j = 0; j<n;j++)
                temp[i][j] = board[i][j];
        }
         dfs(moveleft(board, n), count+1,n,print+"l ");
        for(int i =0; i<n;i++){
            for(int j = 0; j<n;j++)
                board[i][j] = temp[i][j];
        }
       dfs(moveright(board, n), count+1,n,print+"r ");
        for(int i =0; i<n;i++){
            for(int j = 0; j<n;j++)
                board[i][j] = temp[i][j];
        }
        dfs( moveup(board, n), count+1,n,print+"u ");
        for(int i =0; i<n;i++){
            for(int j = 0; j<n;j++)
                board[i][j] = temp[i][j];
        }
         dfs(movedown(board, n), count+1,n,print+"d ");
        for(int i =0; i<n;i++){
            for(int j = 0; j<n;j++)
                board[i][j] = temp[i][j];
        }
    }
    public static int findMax(int[][] board){
        int maxv = Integer.MIN_VALUE;
        for(int i = 0; i< board.length;i++){
            for(int j = 0; j<board[i].length;j++){
                maxv = Math.max(maxv, board[i][j]);
            }
        }
        return maxv;
    }
}
