import java.io.*;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static boolean[] visited;
    static boolean flag = false;
    static ArrayList<Integer>[] people;


    public static void main(String[] args) throws Exception {

        String input = br.readLine();
        String[] nm = input.split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        people = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            String next = br.readLine();
            String[] num = next.split(" ");
            if (people[Integer.parseInt(num[0])] == null) people[Integer.parseInt(num[0])] = new ArrayList<>();
            people[Integer.parseInt(num[0])].add(Integer.parseInt(num[1]));
            if (people[Integer.parseInt(num[1])] == null) people[Integer.parseInt(num[1])] = new ArrayList<>();
            people[Integer.parseInt(num[1])].add(Integer.parseInt(num[0]));
        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
            if (flag == true) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
        return;

    }

    public static void dfs(int thisindex, int depth) {
        if(depth == 5) { flag = true; return;}
        if(people[thisindex] == null) return;
        for(int next: people[thisindex]){
            if(visited[next] == false){
                visited[next] = true;
                dfs(next, depth +1);
                visited[next] = false;
            }
        }

    }

    }
