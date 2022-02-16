import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] A;
    static int n; static int m;


    public static void main(String[] args) throws IOException {

       String input = br.readLine();
       String inputs[] = input.split(" ");
       n = Integer.parseInt(inputs[0]);
       m = Integer.parseInt(inputs[1]);
       A = new int[n][m];
       for(int i = 0; i<n;i++){
           String next = br.readLine();
           String[] each = next.split(" ");
           for(int j = 0; j<m;j++){
               A[i][j] = Integer.parseInt(each[j]);
           }
       }
       String op = br.readLine();
       String[] ops = op.split(" ");
       for(String operation: ops){
           n = A.length;
           m = A[0].length;
           switch(operation){
               case "1":
                   one(); break;
               case "2":
                   two(); break;
               case "3":
                   three(); break;
               case "4":
                   four(); break;
               case "5":
                   five(); break;
               case "6":
                   six(); break;
           }
       }
       for(int i = 0;i<A.length;i++){
           for(int j =0;j<A[0].length;j++){
               if(j == 0)  System.out.print(A[i][j]);
              else System.out.print(" "+A[i][j]);}
           System.out.println();
       }
    }
    public static void one(){
        for(int i =0;i<n/2;i++){
            for(int j = 0; j<m;j++){
                int temp = A[i][j];
                A[i][j] = A[n-1-i][j];
                A[n-1-i][j] = temp;
            }
        }
    }
    public static void two(){
        for(int j =0;j<m/2;j++){
            for(int i= 0; i<n;i++){
                int temp = A[i][j];
                A[i][j] = A[i][m-1-j];
                A[i][m-1-j] = temp;
            }
        }
    }
    public static void three(){
        int[][] temp = new int[m][n];
        for(int i = 0;i<n;i++){
            for(int j = 0; j<m;j++){
                temp[j][Math.abs(n-1-i)] = A[i][j];
            }
        }
        A = temp;
    }
    public static void four(){
        int[][] temp = new int[m][n];
        for(int i = 0;i<n;i++){
            for(int j = 0; j<m;j++){
                temp[Math.abs(m-1-j)][i] = A[i][j];
            }
        }
        A = temp;
    }
    public static void five(){
        int[][] temp = new int[n][m];
        for(int i = 0; i<n/2;i++){
            for(int j = 0; j<m/2;j++) temp[i][j+m/2] = A[i][j];
            for(int j=m/2;j<m;j++) temp[i+n/2][j]= A[i][j];
        }
        for(int i =n/2;i<n;i++){
            for(int j = 0; j<m/2;j++) temp[i-n/2][j] = A[i][j];
            for(int j=m/2;j<m;j++) temp[i][j-m/2]= A[i][j];
        }
        A = temp;
    }
    public static void six(){
        int[][] temp = new int[n][m];
        for(int i = 0; i<n/2;i++){
            for(int j = 0; j<m/2;j++) temp[i+n/2][j] = A[i][j];
            for(int j=m/2;j<m;j++) temp[i][j-m/2]= A[i][j];
        }
        for(int i =n/2;i<n;i++){
            for(int j = 0; j<m/2;j++) temp[i][j+m/2] = A[i][j];
            for(int j=m/2;j<m;j++) temp[i-n/2][j]= A[i][j];
        }
        A = temp;

    }
}
