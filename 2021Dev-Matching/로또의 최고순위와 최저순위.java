import java.util.ArrayList;

class Solution {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int low = 0;
        int high;
        int zerocount = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i: win_nums){
            arr.add(i);
        }
        for(int i : lottos){
            if(arr.contains(i)) low++;
            else if(i==0) zerocount++;
        }
        high = low+zerocount;

        answer[1] = reward(low);
        answer[0] = reward(high);
        return answer;
    }

    public static int reward(int i ){
        switch(i){
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}
