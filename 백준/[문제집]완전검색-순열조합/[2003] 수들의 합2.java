import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int m;
    static int n;
    static int result = 0;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        String inputnumber = br.readLine();
        String[] mandn = inputnumber.split(" ");
        m = Integer.parseInt(mandn[1]);
        n = Integer.parseInt(mandn[0]);
        String next = br.readLine();
        String[] numbers = next.split(" ");
        A = new int[n];
        B = new int[n]; //B[n] : 0부터 n번째 수의 합
        int add = 0;
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(numbers[i]);
            if(A[i]==m) result++;
            add += A[i];
            B[i] = add;
        }

        dfs(new int[2],0,0);
        System.out.println(result);

    }
    public static void dfs(int[] pick, int count, int start){
        if(count == 2){
            if(pick[0] == 0){
                if(B[pick[1]]==m) result++;
            }
            else if(B[pick[1]]-B[pick[0]-1]==m) result++;
            return;
        }
        for(int i = start; i<n;i++){
            pick[count] = i;
            dfs(pick,count+1,i+1);
        }
    }
}
