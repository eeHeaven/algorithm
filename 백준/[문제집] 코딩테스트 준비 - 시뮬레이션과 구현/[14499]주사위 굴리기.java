import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int k;
    static int[][] board;
    static int[][] dice = new int[4][3];


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        String[] inputs = first.split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        k = Integer.parseInt(inputs[4]);
        board = new int[n][m];
        Point start = new Point(Integer.parseInt(inputs[2]),Integer.parseInt(inputs[3]));
        for(int i = 0;i<n;i++){
            String next = br.readLine();
            String[] each = next.split(" ");
            for(int j = 0; j<m;j++)
                board[i][j] = Integer.parseInt(each[j]);
        }
        String last = br.readLine();
        String[] order = last.split(" ");
        for(String each :order){
            switch (each){
                case "1":
                    start = right(start);
                    break;
                case "2":
                    start = left(start);
                    break;
                case "3":
                    start = up(start);
                    break;
                case "4":
                    start = down(start);
                    break;

            }
        }

    }



    public static Point down(Point p){
        int x= p.x;
        int y = p.y;
        if(x+1>=n) return p;
        int temp = dice[3][1];
        for(int i = 2; i>=0;i--){
            dice[i+1][1] = dice[i][1];
        }
        dice[0][1] = temp;
        Point move = new Point(x+1,y);
        mark(move);
        return move;
    }
    public static Point up(Point p){
        int x= p.x;
        int y = p.y;
        if(x-1<0) return p;
        int temp = dice[0][1];
        for(int i = 1; i<=3;i++){
            dice[i-1][1] = dice[i][1];
        }
        dice[3][1] = temp;
        Point move = new Point(x-1,y);
        mark(move);
        return move;
    }
    public static Point right(Point p){
        int x= p.x;
        int y = p.y;
        if(y+1>=m) return p;
        int temp = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = dice[3][1];
        dice[3][1] = dice[1][2];
        dice[1][2] = temp;
        Point move = new Point(x,y+1);
        mark(move);
        return move;
    }
    public static Point left(Point p){
        int x= p.x;
        int y = p.y;
        if(y-1<0) return p;
        int temp = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = dice[3][1];
        dice[3][1] = dice[1][0];
        dice[1][0] = temp;
        Point move = new Point(x,y-1);
        mark(move);
        return move;
    }

    public static void mark(Point p){
        int x= p.x;
        int y = p.y;
        if(board[x][y] != 0){
            dice[3][1] = board[x][y];
            board[x][y] = 0;
        }
        else board[x][y] = dice[3][1];
        System.out.println(dice[1][1]);
    }
    }

    class Point{
    int x;
    int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
