import java.util.*;
class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int onWeight = 0;
        int truck = 0;
        int temp;
        Queue<Integer> onBridge = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();
        Queue<Integer> stayTime = new LinkedList<>();

        for(int i = 0; i<truck_weights.length;i++){
            wait.offer(truck_weights[i]);
        }
        if(!wait.isEmpty()&&onBridge.isEmpty()){
            time++;
            truck = wait.poll();
            onBridge.offer(truck);
            stayTime.offer(1);
            onWeight = truck;
        } // 처음에 트럭 넣기
        while(!onBridge.isEmpty()){
            time++;
            if(stayTime.peek() == bridge_length){
                truck = onBridge.poll();
                stayTime.poll();
                onWeight = onWeight - truck;
            }// 맨 앞에 있는 트럭 통과
            if(!wait.isEmpty())
            { if(onBridge.size()<bridge_length && onWeight + wait.peek() <=weight){
                truck = wait.poll();
                onBridge.offer(truck);
                stayTime.offer(0);
                onWeight= onWeight+truck;
            }}// 다리에 여유가 있으면 트럭 올리기
            for(int j = 0; j<stayTime.size();j++){
                temp = stayTime.poll();
                stayTime.offer(temp+1);
            }
        }
        return time;
    }
}
