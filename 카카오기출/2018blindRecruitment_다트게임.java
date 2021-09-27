class Solution {
    public static int solution(String dartResult) {
        int answer = 0;

        int prev = 0;
        int thisscore=0;
        int i =0;
        while(i<dartResult.length()){
            int key=0;
            if('0'<=dartResult.charAt(i)&&dartResult.charAt(i)<='9'){
                 key = dartResult.charAt(i) -'0';
            }
            if(dartResult.charAt(i) == '1'&& dartResult.charAt(i+1)=='0'){
                key = 10; i++;
            }
            char bonus = dartResult.charAt(++i);
            int bonusnum=0;
            switch (bonus){
                case 'S': bonusnum = 1; break;
                case 'D': bonusnum =2; break;
                case 'T': bonusnum= 3; break;
            }
            if(i+1<dartResult.length()){
            if(dartResult.charAt(i+1)=='*'){
                thisscore = (int)Math.pow((double)key,(double)bonusnum)*2;
                answer+= thisscore+prev;
                i++;
            }
           else if(dartResult.charAt(i+1)=='#'){
                thisscore=(int)Math.pow((double)key,(double)bonusnum)*(-1);
                answer+=thisscore;
                i++;
            }
            else{
                thisscore = (int)Math.pow((double)key,(double)bonusnum);
                answer+=thisscore;
            }}
            else{
                thisscore = (int)Math.pow((double)key,(double)bonusnum);
                answer += thisscore;
            }
            prev = thisscore;
            i++;

        }
        return answer;
    }

    }
