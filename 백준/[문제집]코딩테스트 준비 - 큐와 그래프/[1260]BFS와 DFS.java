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
    static int v;
    static boolean[][] line;
    static boolean[] visit;
    static String dfsresult;
    static String bfsresult;


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        String[] inputs = first.split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        v = Integer.parseInt(inputs[2]);
        line = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];
        dfsresult = Integer.toString(v)+" ";
        bfsresult= Integer.toString(v)+" ";
        for (int i = 0; i < m; i++) {
            String next = br.readLine();
            String[] each = next.split(" ");
            int a = Integer.parseInt(each[0]);
            int b = Integer.parseInt(each[1]);
            line[a][b] = true;
            line[b][a] = true;
        }
        visit[v] = true;
        dfs(v);
        Arrays.fill(visit,false);
        bfs();
        System.out.println(dfsresult.substring(0,dfsresult.length()-1));
        System.out.println(bfsresult.substring(0,bfsresult.length()-1));



    }

    public static void dfs(int node){
        for(int i =1; i<=n;i++){
            if(visit[i] == false && line[node][i] == true){
                visit[i] = true;
                dfsresult = dfsresult+Integer.toString(i)+" ";
                dfs(i);
            }
        }
    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        visit[v] = true;
        q.add(v);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i =1;i<=n;i++){
                if(visit[i] == false && line[node][i]==true){
                    visit[i] = true;
                    bfsresult = bfsresult+Integer.toString(i)+" ";
                    q.add(i);
                }
            }
        }
    }
}
