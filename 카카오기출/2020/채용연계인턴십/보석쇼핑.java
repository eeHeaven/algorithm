import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static HashMap<String, Integer> jewelget;
    static HashSet<String> jewel = new HashSet<>();
    static Queue<Integer> jewelgetindex;
    static int min = Integer.MAX_VALUE;
    static int gemKind;
    static int startIndex = 0;
    static int endIndex = 0;
    static int[] answer = new int[2];

    public static void main(String[] args) {
        String[] gems = {"A", "B" ,"B", "C", "A", "B", "C", "A","B","C"};
        System.out.println(solution(gems)[0]+" "+solution(gems)[1]);
    }
    public static int[] solution(String[] gems) {
        for(String gem : gems){
            jewel.add(gem);
        }
        gemKind = jewel.size();
        int index = 0;
        while(index<gems.length){
            jewelget = new HashMap<>();
            jewelgetindex = new LinkedList<>();
            int count = 0;
            while(count<gemKind&& index<gems.length){
                if(!jewelget.containsKey(gems[index])) count++;
                jewelget.put(gems[index], jewelget.getOrDefault(gems[index],0)+1);
                jewelgetindex.add(index);
                index++;
            }
            if(count <gemKind) break;
            endIndex =  index;
            while(true){
                String thisgem = gems[jewelgetindex.peek()];
                jewelget.put(thisgem,jewelget.get(thisgem)-1);
                if(jewelget.get(thisgem)==0){
                    startIndex = jewelgetindex.peek()+1;
                    break;
                }
                else jewelgetindex.poll();
            }
            if(min != endIndex-startIndex+1)
            { min = Math.min(min,endIndex-startIndex+1);
            if(endIndex-startIndex+1 == min){
                answer[0] = startIndex;
                answer[1] = endIndex;
            }}
            if(endIndex-startIndex+1==gemKind) break;
            index = startIndex;
        }
        return answer;
    }
}
