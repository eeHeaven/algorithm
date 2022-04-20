class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i<5;i++){
            char[][] room = new char[5][5];
            for(int j = 0; j<5;j++){
                for(int k = 0; k<5;k++){
                    room[j][k] = places[i][j].charAt(k);
                }
            }
            if(isValid(room)) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
    public static boolean isValid(char[][] room){
        for(int i = 0; i<5;i++){
            for(int j = 0; j<5;j++){
                if(room[i][j] == 'P'){
                if(isInRange(i,j+1)){
                    if(room[i][j+1] == 'P') return false;
                }
                if(isInRange(i+1,j)){
                    if(room[i+1][j] == 'P') return false;
                }
                if(isInRange(i,j+2)){
                    if(room[i][j+2]=='P'&&room[i][j+1]!='X') return false;
                }
                    if(isInRange(i+2,j)){
                        if(room[i+2][j]=='P'&&room[i+1][j]!='X') return false;
                    }
                if(isInRange(i+1,j+1)){
                    if(room[i+1][j+1]=='P'&&(room[i+1][j]!='X'||room[i][j+1]!='X')) return false;
                }
                    if(isInRange(i+1,j-1)){
                        if(room[i+1][j-1]=='P'&&(room[i+1][j]!='X'||room[i][j-1]!='X')) return false;
                    }
            }
            }
        }
        return true;
    }

    public static boolean isInRange(int x, int y){
        if(x<0||y<0||x>=5||y>=5) return false;
        else return true;
    }
}
