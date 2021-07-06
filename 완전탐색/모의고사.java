import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> ans = new ArrayList<Integer>();

        int[] score = {0,0,0};

        int [] a1 = {1,2,3,4,5};
        int [] a2 = {2,1,2,3,2,4,2,5};
        int [] a3 = {3,3,1,1,2,2,4,4,5,5};

        int max = 0;


        for(int i = 0; i<answers.length;i++){

            if(answers[i] == a1[i%(a1.length)])
                score[0]++;
            if(answers[i] == a2[i%(a2.length)])
                score[1]++;
            if(answers[i] == a3[i%(a3.length)])
                score[2]++;
        }

        for(int i = 0; i<3; i++){
            if(score[i]>max) max = score[i];
        }
        for(int i = 0; i<3; i++){
            if(score[i] == max) 
                ans.add(i+1);
        }
        int[] answer = new int[ans.size()];
        answer = ans.stream().mapToInt(i -> i).toArray();



        return answer;
    }
}
