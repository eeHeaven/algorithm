import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int a = 0,b = 0,c = 0,len = 0;
        int index = 0;
        for( int i = 0; i< commands.length;i++){
            a = commands[i][0];
            b = commands[i][1];
            c = commands[i][2];
            len = b - a + 1;
            int[] arr = new int[len];
            
            for(int j = a - 1, k =0; j<b; k++,j++){
                arr[k]= array[j];
            }
            Arrays.sort(arr);
            answer[index] = arr[c-1];
            index++;
        }
        return answer;
    }
}
