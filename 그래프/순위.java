import java.util.*;
class Solution {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int count;
        int node;
        boolean[] visit;
        for(int i = 1; i<=n;i++){
            count = 0;
            visit = new boolean[n+1];
            q.add(i);
            visit[i] = true;
            while(!q.isEmpty()){
                node = q.poll();
                for(int j = 0;j<results.length;j++){
                    if(!visit[results[j][1]]&&results[j][0]==node){
                        q.add(results[j][1]);
                        count++;
                        visit[results[j][1]] = true;
                    }
                }
            }
            visit = new boolean[n+1];
            q.add(i);
            visit[i] = true;
            while(!q.isEmpty()){
                node = q.poll();
                for(int j = 0;j<results.length;j++){
                    if(!visit[results[j][0]]&&results[j][1]==node){
                        q.add(results[j][0]);
                        count++;
                        visit[results[j][0]] = true;
                    }
                }
            }
         if(count == n-1) answer++;
        }
        return answer;
    }
}
