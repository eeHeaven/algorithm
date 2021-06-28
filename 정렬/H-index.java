
import java.util.ArrayList;
import java.util.Iterator;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<citations.length;i++){
        int high = 0;
            for(int j = 0; j<citations.length;j++){
                if(citations[i]<=citations[j]){
                    high++;
                }
            }
            if(high >= citations[i])
                list.add(citations[i]);
            else list.add(high);
        }

        Iterator<Integer> it =list.iterator();
        int max = 0;
        int key;
        while(it.hasNext()){
            key = it.next();
            if(key>max) max = key;
        }
        answer = max;
        return answer;
    }
}
