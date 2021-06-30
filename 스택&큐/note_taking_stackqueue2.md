# 프로그래머스 코딩테스트 연습 정렬문제 

## 프린터 문제 
> 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.                  
> 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.         
>1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
>2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.      
>3. 그렇지 않으면 J를 인쇄합니다.  
>     
>예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.          
내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.             
현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,            
내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.     

>입출력 예) priorities = {2,1,3,2}  location = 2 -> return: 1

* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**Int형 array를 내림차순으로 sort할때는 Integer로 Wrapper class 변환 필요**        
오름차순으로 정렬할때는 그냥 Arrays.sort(arr)하면 되는데 내림차순은 그게 안됨       
```java
Integer[] integerArr = new Integer[] {1,3,5,2,4}; 
String[] stringArr = new String[] {"A","C","B","E","D"}; 

Arrays.sort(integerArr,Comparator.reverseOrder()); //내림차순 
Arrays.sort(stringArr,Collections.reverseOrder()); //내림차순
```
**Int형 배열 Wrapper class로 바꾸는 법**     
Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);              

- steam 개념 하나도 모르는데 steam 자꾸 나오네... 나중에 하루 각잡고 공부해야 할 듯. 객체지향 개념도

**indexOf도 String배열이나 Wrapper class 일때만 사용 가능**          
이걸 하나하나 전부 외울 수는 없겠지만 구글링할때 이 점을 주의해서 볼 것. 삽질하지 말고         

************************************


* 문제 풀이 코드 
```java
import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> loc = new LinkedList<>();
        int[] order = new int[priorities.length];
        Integer[] arr = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Comparator.reverseOrder());
        int maxindex = 0;

        for(int i = 0; i<priorities.length;i++){
            q.offer(priorities[i]);
            loc.offer(i);}

        while(!q.isEmpty()){
                if(q.peek()<arr[maxindex]){
                    q.offer(q.poll());
                    loc.offer(loc.poll());}
                else{
                    q.poll();
                    order[maxindex] = loc.poll();
                    maxindex++;
                }
            }
        for(int i = 0; i<order.length;i++) {
            if (order[i] == location)
                return (i + 1);
        }
        return -1;
        }


    }
```
