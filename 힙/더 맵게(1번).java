import java.util.*; 

class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int food1,food2 = 0;
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for(int i = 0; i<scoville.length;i++){
            foods.add(scoville[i]);
        }

        while(!foods.isEmpty()){
            while(foods.peek()<K){
                food1 = foods.poll();
                if(!foods.isEmpty()) food2 = foods.poll();
                else return -1;
                foods.add(food1+(food2*2));
                answer++;
            }
            return answer;
        }
        return -1;
    }
}
