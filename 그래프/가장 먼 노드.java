import java.util.*;
class Solution{

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        boolean[][] vertex = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < edge.length;i++){
            vertex[edge[i][0]-1][edge[i][1]-1] = true;
            vertex[edge[i][1]-1][edge[i][0]-1] = true;
        }
        int qSize;
        int node;
        q.add(0);
        visit[0] = true;
        while(!q.isEmpty()){
           qSize =q.size();
           for(int i = 0;i<qSize;i++){
             node=q.poll();
             for(int j = 0;j<n;j++){
                 if(vertex[node][j]&&!visit[j]){
                     q.add(j);
                     visit[j] = true;
                 }
             }
           }
           answer = qSize;
        }
        return answer;
    }
}
