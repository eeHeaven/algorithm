import java.io.*;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int k;
    static boolean[] visited;
    static int[] parentroute;
    static Queue<Integer> q = new LinkedList<>();


    public static void main(String[] args) throws Exception {

        String input = br.readLine();
        String[] nk= input.split(" ");
        n= Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        if(n == k){
            System.out.println(0);
            System.out.println(n);
            return;
        }

        visited = new boolean[100001];
        parentroute = new int[100001];
        visited[n] = true;
        q.add(n);
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == k){
                Stack<Integer> stack = new Stack<>();
                stack.add(k);
               int parentnode = k;
               while(true){
                   parentnode = parentroute[parentnode];
                   stack.add(parentnode);
                   if(parentnode == n) break;
               }
                System.out.println(stack.size()-1);
               int temp = stack.size();
               for(int i = 0; i<temp;i++) System.out.print(stack.pop()+" ");
                return;
            }
            if(node+1<=100000){
                if(visited[node+1]==false){
                    visited[node+1] = true;
                    q.add(node+1);
                    parentroute[node+1] = node;
                }
            }
            if(node-1>=0){
                if(visited[node-1]==false){
                    visited[node-1] = true;
                    q.add(node-1);
                    parentroute[node-1] = node;
                }
            }
            if(node*2<=100000){
                if(visited[node*2]==false){
                    visited[node*2] = true;
                    q.add(node*2);
                   parentroute[node*2] = node;
                }
            }
        }
    }
}
