import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int count = 0;
    public static int[] rowNcolumn;

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        int n = Integer.parseInt(input);
        rowNcolumn = new int[n];
        combination(0,n);
        System.out.println(count);

    }

    public static void combination(int row, int n){
        if(row == n){
            count++;
            return;
        }
        for(int i = 0; i<n;i++){
            rowNcolumn[row] = i;
            if(isOktoPut(row)){
                combination(row+1,n);
            }
        }
    }

    public static boolean isOktoPut(int row){
        for(int i = 0; i<row;i++){
            if(rowNcolumn[row] == rowNcolumn[i]) return false;
        }
        int column = rowNcolumn[row];
        for(int i = 0; i<row;i++){
            if(Math.abs(row-i)==Math.abs(column - rowNcolumn[i])) return false;
        }
        return true;
    }
}
