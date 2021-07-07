import java.util.*;

class Solution {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        boolean[] check = new boolean[7];
        String temp = "";
        void dfs(String numbers, String temp, int m){
            if(temp.length()==m){
                int num = Integer.parseInt(temp);
                if(!arr.contains(num))
                    arr.add(num);
                return;
            }
            else{
                for(int i =0;i<numbers.length();i++){
                    if(!check[i]){
                        check[i] = true;
                        temp +=numbers.charAt(i);
                        dfs(numbers,temp,m);
                        check[i] = false;
                        temp = temp.substring(0,temp.length()-1);
                    }
                }
            }
        }
        
        void isPrime(int n){
            if(n ==0 || n==1) return;
            for(int i = 2; i<n;i++){
                if(n%i == 0) return;
            }
            answer++;
        }
        
         public int solution(String numbers) {

             for(int i = 0;i<numbers.length();i++){
                 dfs(numbers,temp,i+1);
             }
             for(int i =0; i<arr.size();i++){
                 isPrime(arr.get(i));
             }
        return answer;
    }
}
