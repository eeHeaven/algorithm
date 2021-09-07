class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int rx = 3, ry = 2;
        int lx = 3, ly = 0;

        int keyx =3;
        int keyy =1;
        int rmove=0, lmove =0;
        for(int i = 0; i<numbers.length;i++){
            int key = numbers[i];
            if(key !=0) {keyx = (key-1)/3;
             keyy = (key-1)%3;}
            if(key ==0){ keyx=3; keyy =1;}

            if(keyy ==0){sb.append("L"); lx = keyx; ly = keyy; continue;}
            else if(keyy ==2){sb.append("R"); rx = keyx; ry = keyy; continue;}
            rmove = Math.abs(rx-keyx)+Math.abs(ry-keyy);
            lmove = Math.abs(lx-keyx)+Math.abs(ly-keyy);

            if(rmove> lmove) {sb.append("L"); lx = keyx; ly = keyy;}
            else if(rmove<lmove) {sb.append("R"); rx = keyx; ry = keyy;}
            else {
                if(hand.equals("left")) {sb.append("L"); lx = keyx; ly = keyy;}
                else{sb.append("R"); rx = keyx; ry = keyy;}}

        }
        answer = sb.toString();
        return answer;
    }
}
