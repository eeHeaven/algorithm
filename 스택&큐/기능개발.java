import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< progresses.length;i++){
       
int day = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            if(q.isEmpty()){
                q.offer(day);
            }
            else{
                if(q.peek()>=day){
                    q.offer(day);
                    continue;
                }
                else {
                    ans.add(q.size());
                    q.clear();
                    q.offer(day);
                }
            }
        }
        ans.add(q.size());
        answer=ans.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
