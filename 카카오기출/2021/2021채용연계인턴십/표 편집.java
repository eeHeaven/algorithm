import java.util.*;
class Solution {
    static int[] up;
    static int[] down;
    static boolean[] delete;
    static Stack<DeletedRow> stack = new Stack<>();
    static int index;

    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        up = new int[n];
        down = new int[n];
        delete = new boolean[n];
        index = k;
        for(int i = 0; i<n;i++){
            up[i] = i-1;
            down[i] = i+1;
        }
        down[n-1] = -1;
        for(String order : cmd){
            String[] orders = order.split(" ");
            switch(orders[0]){
                case "U":
                    int x = Integer.parseInt(orders[1]);
                    doUp(x);
                    break;
                case "D":
                    int y = Integer.parseInt(orders[1]);
                    doDown(y);
                    break;
                case "C":
                    doC();
                    break;
                case "Z":
                    doZ();
                    break;
            }
        }
        for(int i = 0; i<n;i++){
            if(delete[i])sb.append("X");
            else sb.append("O");
        }
        String answer = sb.toString();
        return answer;
    }
    public static void doUp(int x){
        for(int i = 0; i<x;i++) index = up[index];
    }
    public static void doDown(int x){
        for(int i = 0; i<x;i++) index = down[index];
    }
    public static void doC(){
        delete[index] = true;
        int upIndex = up[index];
        int downIndex = down[index];
        stack.push(new DeletedRow(index,upIndex,downIndex));
        if(upIndex!= -1) down[upIndex] = downIndex;
        if(downIndex!= -1){
            up[downIndex] = upIndex;
            index = downIndex;
        }
        else {index = upIndex;}
    }
    public static void doZ(){
        DeletedRow restore = stack.pop();
        int thisindex = restore.index;
        int upIndex = restore.upIndex;
        int downIndex = restore.downIndex;
        delete[thisindex] = false;
       if(downIndex != -1) up[downIndex] = thisindex;
       if(upIndex != -1) down[upIndex] = thisindex;
    }
    static class DeletedRow{
        int index;
        int upIndex;
        int downIndex;

        public DeletedRow(int index, int upIndex, int downIndex) {
            this.index = index;
            this.upIndex = upIndex;
            this.downIndex = downIndex;
        }
    }
}
