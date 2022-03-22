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
    static boolean[][] line;
    static boolean[] visit;
    static int count = 0;


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        String[] inputs = first.split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        line = new boolean[n+1][n+1];
        visit = new boolean[n+1];

        for(int i = 0; i<m;i++){
            String next= br.readLine();
            String[] each = next.split(" ");
            int a = Integer.parseInt(each[0]);
            int b = Integer.parseInt(each[1]);
            line[a][b] = true;
            line[b][a] = true;
        }

        for(int i = 1;i<=n;i++){
            if(visit[i] == false){
                visit[i] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                bfs(q);
            }
        }
        System.out.println(count);

    }
    public static void bfs(Queue<Integer> q){
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i =1;i<=n;i++){
                if(line[node][i]==true && visit[i] == false){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
        count++;
    }
}
