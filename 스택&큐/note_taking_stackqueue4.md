# 프로그래머스 코딩테스트 연습 스택/큐문제 

## 주식가격 문제 
> 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.        
입출력 예:prices = {1,2,3,2,3} 리턴 값 = {4,3,1,1,0}                       
1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.                  
2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.               
3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.              
4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.             
5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.               
      
* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**시간에 따른 데이터 -> index 활용하기**           
이 문제는 prices 배열 자체가 시간에 따른 데이터로 주어진 문제이다            
게다가 리턴 값은 prices 배열에서의 value랑 전혀 상관없이 시간별로 카운트한 값만 각각 내주면 된다            
따라서 큐/스택을 활용할때 prices 배열의 value 값을 무조건 이용하려고 하지말고 index를 활용하는 것이 유용하다            

**정렬로 이중 for문으로 단순한 풀이가 생각나지만 효율성에서 걸릴 때, 사용해야 할 스택/큐 풀이법**            
1. for 문으로 데이터 값 하나하나씩 접근 
2. 접근한 값을 큐/스택에 넣기 
3. 이때 무조건 다 넣는 것이 아니라 큐/스택이 비었을 때만 넣기 
4. 큐/스택이 비어있지 않을 때는 큐/스택 안의 값과 현재 for문에서 접근한 데이터 값 비교 
5. 이후 식은 문제 상황에 맞게 융통적으로 변형  
************************************


* 문제 풀이 코드        
  - 내가 푼 코드 
```java
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop(); // 답을 구했기 때문에 stack에서 제거한다
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            ans[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return ans;
    }

}
```
