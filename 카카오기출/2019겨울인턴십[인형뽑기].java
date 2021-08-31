import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    static int answer = 0;

    public static int solution(int[][] board, int[] moves) {
        Stack<Integer>[] lines = new Stack[5];
        for(int i = 0; i<5;i++){
            lines[i] = new Stack<Integer>();
        }
        Stack<Integer> bucket = new Stack<>();
        Queue<Integer> items = new LinkedList<>();
        // 뽑기 board 설정 (각 line은 board의 세로줄)
        for(int i = board.length-1;i>=0;i--){
            for(int j =0;j< board.length;j++){
                if(board[i][j]==0) continue;
                else lines[j].add(board[i][j]);
            }
        }
        int item, key;
        for(int i = 0; i<moves.length;i++){
             key = moves[i]-1;
            if(lines[key].isEmpty()) continue;
           else {item = lines[key].pop();
               items.add(item);
           }
        }
        insert(bucket,items);

        return answer;
    }

    public static void insert(Stack<Integer> bucket, Queue<Integer> items){
        if(items.isEmpty()) return;
        int item = items.poll();
        if(!bucket.isEmpty()&&bucket.peek()==item){
            bucket.pop();
            answer=answer+2;
            insert(bucket,items);
        }
        else {bucket.push(item); insert(bucket,items);}
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }
}
