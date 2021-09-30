class Solution {
    static int answer = 0;
    public static int solution(int[] food_times, long k) {

        dfs(k, food_times.length,food_times);
        return answer;
    }

    public static void dfs(long leftTime, int leftFood,int[] food_times){
        if(leftFood <= 0){answer = -1; return;}
        long eatten = leftTime/leftFood;
        long foodToEat = leftTime%leftFood;
        
        if(eatten <=0){
            for (int i = 0; i<food_times.length;i++){
                if(food_times[i] == 0) continue;
                leftTime--;
                if(leftTime == -1) {answer = i+1;}
                
            }
            return;
        }

        for(int i = 0; i<food_times.length;i++){
            if(food_times[i] == 0) continue;
            else if(food_times[i] - eatten <0){
                foodToEat+=eatten - food_times[i];
                food_times[i] = 0;
                leftFood --;
            }
            else{
                food_times[i] = food_times[i] - (int)eatten;
                if(food_times[i] == 0) leftFood--;
            }
        }
        dfs(foodToEat, leftFood, food_times);
    }
}
