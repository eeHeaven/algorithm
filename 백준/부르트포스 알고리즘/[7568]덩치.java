import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String N = br.readLine();
        int n = Integer.parseInt(N);
        int[][] info = new int[n][3];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] infos = line.split(" ");
            int height = Integer.parseInt(infos[0]);
            int weight = Integer.parseInt(infos[1]);
            info[i][0] = height;
            info[i][1] = weight;
        }
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (info[j][0] > info[i][0] && info[j][1] > info[i][1]) count++;
            }
            info[i][2] = count;
            if (i == n - 1) System.out.print(count);
            else System.out.print(count + " ");
        }
    }
}
