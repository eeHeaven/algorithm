# 프로그래머스 코딩테스트 연습 완전탐색

## 소수찾기 문제 
> 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.             
각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.       
입출력 예시: input)17 output)3/ input)011 output)2           

* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**String 객체에서 charAt(index)사용해서 문자 하나씩 꺼내기**            
이거 몰라서 뻘짓함... charAt 메소드 있는거 잊지 말자..            

### 백트래킹                
자 이 문제의 핵심이다.. 백트래킹        
물론 내가 엄청 똑똑하면 이거 몰라도 대충 구현해서 풀 수 있었겠지만 나는 그런 천재가 아니니까        
모르면 공식화해서 외우면 된다.. 백트래킹 외우자                 

**백트래킹 이란?**           
백트래킹 알고리즘이란 모든 경우의 수를 검색하는 알고리즘이다.          
"특정조건"을 만족하는 모든 경우의 수를 찾고 싶을 때 사용하면 유용하다.              

**백트래킹의 핵심 1) 재귀함수**            
**백트래킹의 핵심 2) 재귀함수 처음에 if로 탐색이 만족할 때(완료할 때)를 선제시하기 + return**              
**백트래킹의 핵심 3) boolean으로 갈 수 있는(방문할 수 있는) 길을 check하고 표시하기**            
**백트래킹의 핵심 4) else문에서 재귀함수 호출 후 방문한 길을 false로 바꾸고 그 외에 back track할 사항들 back하기**        
(본 예시에서 back track할 사항은 temp문자열을 줄이는 일임)            


**소수탐색 함수**            
쉽지만 막상 생각하려고 하면 안떠오를 수 있으니 주의하기       
아예 함수로 정의해서 사용하면 편함           
n == 0이거나 n == 1 일때는 그냥 return            
for문 돌려서 i<n일때까지 중 n%i == 0이면 return              
************************************


* 문제 풀이 코드 
```java
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
```
