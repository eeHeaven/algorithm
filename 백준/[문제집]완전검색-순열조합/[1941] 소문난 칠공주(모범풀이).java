import java.awt.*; 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.LinkedList; 
import java.util.Queue; 
public class Main { 
    //파벌 
    static char[][] map = new char[5][5]; 
    static int[] moveX = {1,-1,0,0}; 
    static int[] moveY = {0,0,1,-1}; 
    static int[] combX = new int[25]; 
    static int[] combY = new int[25]; 
    
    //연속해서 7개->S가 적어도 4개 //DFS, BFS를 사용하면 T모양 같은게 안됨 
    static int answer = 0; 
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        for(int i=0; i<5; i++){ 
            map[i] = br.readLine().toCharArray(); } 
        
        //좌표화 
        for(int i=0; i<25; i++){
            combX[i] = i % 5; combY[i] = i / 5; 
        } 
        Combination(new int[7], 0,0,7);
        System.out.println(answer); 
    } 
    
    //25개중 7개 뽑기 
    public static void Combination(int[] combination, int index, int count, int left){
        if(left == 0){
            BFS(combination); return; 
        } 
        if(count == 25) return; 
        combination[index] = count; 
        Combination(combination,index+1, count+1, left-1); 
        Combination(combination,index,count+1,left); 
    } 
    public static void BFS(int[] comb){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[7];
        q.add(comb[0]);
        int count = 1, countS = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            if(map[combY[cur]][combX[cur]] == 'S') countS++;
            for(int i=0; i<4; i++){
                for(int a=1; a<7; a++){
                    if(!visited[a] && combX[cur]+moveX[i] == combX[comb[a]] && combY[cur]+ moveY[i] == combY[comb[a]]){
                        visited[a] = true; q.add(comb[a]);
                        count++;
                    } 
                } 
            } 
        } 
        if(count == 7){
            if(countS >= 4){
                answer++; 
            } 
        } 
    } 
}
