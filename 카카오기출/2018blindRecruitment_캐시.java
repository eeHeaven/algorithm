import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> q = new LinkedList<>();

        if(cacheSize ==0) return cities.length*5;

        for(String city:cities){
            city =city.toLowerCase();

            if(q.contains(city)){
                answer+=1;
                q.remove(city);
                q.add(city);
            }
            else if(q.size()<cacheSize){
                q.add(city);
                answer+=5;
            }
            else{
                q.poll();
                q.add(city);
                answer+=5;
            }
        }
        return answer;
    }
}
