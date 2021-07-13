class Solution {
    int[] answer = new int[2];
        int height, horizon;
        int sum, mul;

     public boolean isRight(int a,int b){
            if((a*b == mul) && (a+b == sum)) return true;
            else return false;
        }

    public int[] solution(int brown, int yellow) {

        sum= (brown+4)/2;
        mul= brown+yellow;

        horizon = sum - 1;
        height = 1;

        while(!isRight(horizon,height)){
            horizon--;
            height++;
        }

        answer[0] = horizon;
        answer[1] = height;
        return answer;
    }
}
