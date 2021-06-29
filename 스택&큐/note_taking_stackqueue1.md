# 프로그래머스 코딩테스트 연습 정렬문제 

## 기능개발 문제 
> 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.     
또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.     
먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.       

* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**강제 형변환 시 괄호로 묶지 말 것!!**      
이걸로 삽질 엄청 오래했다..ㅎㅎㅎㅎ 강제 형변환 할 때 괄호로 묶으면 값이 원하는 대로 안나오고 이상해짐          
ex) int a= (int)1.0 + 2.0;      -> 맞는 표현             
    ~~int a = (int)(1.0+2.0);~~  -> 틀린 표현       

**큐 선언 및 사용**        
Queue<값의 제네릭 자료형> q = new LinkedList<>();       
q.offer(값);         
q.poll();       첫번째 값을 빼내고 동시에 return/ 비어있다면 null return      
q.remove();     첫번째 값 제거        
q.clear();      
q.peek();       첫번째 값을 빼내지 않고 그냥 return 하기만         
q.size(); 

**Math.ceil(double형 값)**        
값을 소숫점 첫째 자리에서 올림하여 정수 형태로 변환하기 좋음      
round: 반올림/ floor: 버림        

  

************************************


* 문제 풀이 코드 
```java
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< progresses.length;i++){
       
int day = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            if(q.isEmpty()){
                q.offer(day);
            }
            else{
                if(q.peek()>=day){
                    q.offer(day);
                    continue;
                }
                else {
                    ans.add(q.size());
                    q.clear();
                    q.offer(day);
                }
            }
        }
        ans.add(q.size());
        answer=ans.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
```
