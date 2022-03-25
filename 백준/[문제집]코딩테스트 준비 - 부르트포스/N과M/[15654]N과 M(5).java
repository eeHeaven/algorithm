import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int array[];
    static StringBuilder sb = new StringBuilder();
    static int[] temp;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        String[] each = first.split(" ");
        n = Integer.parseInt(each[0]);
        m = Integer.parseInt(each[1]);
        String next = br.readLine();
        String[] num = next.split(" ");
        array = new int[n];
        visit = new boolean[n];
        temp = new int[m];
        for(int i = 0; i<n;i++){
            array[i] = Integer.parseInt(num[i]);
        }
        Arrays.sort(array);
        combination(0);
        System.out.println(sb.toString());
    }

    public static void combination(int count){
        if(count == m){
            for(int i = 0 ;i<m;i++){
                sb.append(temp[i]+" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }
        for(int i =0;i<array.length;i++){
            if(visit[i] == false){
                visit[i] = true;
                temp[count] = array[i];
                combination(count+1);
                visit[i] = false;
            }
        }
    }
}
