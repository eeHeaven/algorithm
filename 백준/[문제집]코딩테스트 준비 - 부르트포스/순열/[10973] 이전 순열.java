import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static Integer[] num;


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        n = Integer.parseInt(first);
        num = new Integer[n];
        String next = br.readLine();
        String[] each = next.split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(each[i]);
        }

        int swapPoint = -1;
        for (int i = n - 1; i > 0; i--) {
            if (num[i - 1] > num[i]) {
                swapPoint = i - 1;
                break;
            }
        }
        if (swapPoint == -1) {
            System.out.println(-1);
            return;
        }
        for (int i = n-1 ; i > swapPoint; i--) {
            if (num[i] < num[swapPoint]) {
                int temp = num[i];
                num[i] = num[swapPoint];
                num[swapPoint] = temp;
                break;
            }
        }
        Arrays.sort(num, swapPoint + 1, num.length, Comparator.reverseOrder());
        for(int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }

    }
}
