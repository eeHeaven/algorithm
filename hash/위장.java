import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap < String, Integer> map = new HashMap<>();
        String s;
        
        for(int i =0; i< clothes.length; i++){
        s = clothes[i][1];
            if(map.get(s)!=null){
                map.put(s,map.get(s) + 1);
            }
            else {map.put(s,1);}
            
        }
            
        
        Iterator<Integer> it = map.values().iterator();
    while(it.hasNext()){
        answer *= it.next().intValue() + 1;
    }
        
       
    return answer - 1;
    }}
