class Solution {
   static int[][] entire;
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        entire = new int[rows+1][columns+1];
        for(int i=1;i<=rows;i++){
            for(int j = 1; j<=columns;j++){
                entire[i][j] = (i-1)*columns+j;
            }
        }
        int index = 0;
        for(int[] revolve: queries){
           answer[index++] =  revolve(revolve);
        }
        return answer;
    }
    public static int revolve(int[] revolve){
        int x1 = revolve[0];
        int y1 = revolve[1];
        int x2 = revolve[2];
        int y2 = revolve[3];

        int temp = entire[x1][y1];
        int min = 99999;
        for(int i = 1;i<=x2-x1;i++){
            entire[x1+i-1][y1] = entire[x1+i][y1];
            if( entire[x1+i][y1]<min) min= entire[x1+i][y1];
        }
        for(int i = 1;i<=y2-y1;i++){
            entire[x2][y1+i-1] = entire[x2][y1+i];
            if( entire[x2][y1+i]<min) min= entire[x2][y1+i];
        }
        for(int i = 1;i<=x2-x1;i++){
            entire[x2-i+1][y2] = entire[x2-i][y2];
            if( entire[x2-i][y2]<min) min= entire[x2-i][y2];
        }
        for(int i = 1;i<=y2-y1-1;i++){
            entire[x1][y2-i+1] = entire[x1][y2-i];
            if( entire[x1][y2-i]<min) min= entire[x1][y2-i];
        }
        entire[x1][y1+1] = temp;
        if(temp<min)min = temp;
        return min;

    }

   
}
