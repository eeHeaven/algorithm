# 프로그래머스 코딩테스트 연습 완전탐색

## 모의고사 문제 
> 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.         
1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...        
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...        
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...         
1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.           

* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**원래는 Stream 사용해서 ArrayList를 int형 배열로 바꾸려고 했으나 이 경우 시간 효율이 떨어짐**             
따라서 for문을 써서 하나하나 값을 넣어주는 것이 효과적              
여기서 새롭게 찾아낸 방법:              
**return 값이 int형 배열이지만 배열의 원소의 개수가 input에 따라 유동적일 경우,           
return 할 정답 배열과 별개로 arraylist를 생성하여 그곳에 정답을 넣은 다음       
arraylist의 크기만큼 int형 배열의 크기를 정의해주기**                     

ArrayList는 배열이기 때문에 index마다 순차적인 접근 가능하다는 것을 잊으면 안됨!!!             
list.get(index)형태로 값 꺼낼 수 있음 for문으로 돌려서 값 꺼내기 가능                 

  

************************************


* 문제 풀이 코드 
```java
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> ans = new ArrayList<Integer>();
        
        int[] score = {0,0,0};
        
        int [] a1 = {1,2,3,4,5};
        int [] a2 = {2,1,2,3,2,4,2,5};
        int [] a3 = {3,3,1,1,2,2,4,4,5,5};
       
        int max = 0;
       
        
        for(int i = 0; i<answers.length;i++){
       
            if(answers[i] == a1[i%(a1.length)])
                score[0]++;
            if(answers[i] == a2[i%(a2.length)])
                score[1]++;
            if(answers[i] == a3[i%(a3.length)])
                score[2]++;
        }
        
        for(int i = 0; i<3; i++){
            if(score[i]>max) max = score[i];
        }
        for(int i = 0; i<3; i++){
            if(score[i] == max) 
                ans.add(i+1);
        }
        
        int[] answer = new int[ans.size()];
        
        for(int i = 0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        
        
        return answer;
    }
}
```
