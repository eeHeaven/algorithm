import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(String s) {
        Queue<String> arr = new LinkedList<String>();
        int min = 10000;
        if(s.length()==1) return 1;
        for(int i = 1;i<=s.length()/2;i++){
            int answer = 0;
            int j =0;
            while(i+j<=s.length()){
                arr.add(s.substring(j,i+j));
                j=i+j;
            }
            if(j<s.length()) arr.add(s.substring(j));
            String prev = arr.poll();
            int repeat =1;
            while(!arr.isEmpty()){
                if(arr.peek().equals(prev)) repeat++;
                else{if(repeat>1) answer+=i+(int)(Math.log10(repeat)+1);
                else answer+=i;
                repeat =1;}
                prev = arr.poll();
            }
            if(repeat>1) answer+=i+(int)(Math.log10(repeat)+1);
            else answer+=prev.length();
            if(answer<min) min = answer;
        }
        return min;
    }
}
