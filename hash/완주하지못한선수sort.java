import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
         String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i<completion.length; i++){
            if(!completion[i].equals(participant[i])) {answer = participant[i]; return answer;}
        }
        answer = participant[participant.length - 1];
        return answer;
    }
}
