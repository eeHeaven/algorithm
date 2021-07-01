# 프로그래머스 코딩테스트 연습 정렬문제 

## 다리를 지나는 트럭 문제 
> 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.                
> 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.                 
>예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.solution 함수를 완성하세요.       

![캡처](https://user-images.githubusercontent.com/84822464/124137681-df4eee00-dac0-11eb-8f9c-3ad73424881b.PNG)

* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**사실 내가 푼 코드에 새로운 문법은 없었음..**           
근데 그냥 문제 꼼꼼하게 처음에 분석하지 못해서 뻘짓했지ㅎㅎ                
그리고 Queue 는 데이터 set이 따로 안되더라고? 그래서 생각해낸 방법이 그냥 for문 돌려서 하나씩 poll했다가 값 변경하고 다시 offer하면서 한 바퀴 도는 방법            
다음에도 Queue에서 데이터 변경할 일 있으면 이렇게 해야지             



  

************************************


* 문제 풀이 코드        
  - 내가 푼 코드 
```java
import java.util.*;
class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int onWeight = 0;
        int truck = 0;
        int temp;
        Queue<Integer> onBridge = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();
        Queue<Integer> stayTime = new LinkedList<>();

        for(int i = 0; i<truck_weights.length;i++){
            wait.offer(truck_weights[i]);
        }
        if(!wait.isEmpty()&&onBridge.isEmpty()){
            time++;
            truck = wait.poll();
            onBridge.offer(truck);
            stayTime.offer(1);
            onWeight = truck;
        } // 처음에 트럭 넣기
        while(!onBridge.isEmpty()){
            time++;
            if(stayTime.peek() == bridge_length){
                truck = onBridge.poll();
                stayTime.poll();
                onWeight = onWeight - truck;
            }// 맨 앞에 있는 트럭 통과
            if(!wait.isEmpty())
            { if(onBridge.size()<bridge_length && onWeight + wait.peek() <=weight){
                truck = wait.poll();
                onBridge.offer(truck);
                stayTime.offer(0);
                onWeight= onWeight+truck;
            }}// 다리에 여유가 있으면 트럭 올리기
            for(int j = 0; j<stayTime.size();j++){
                temp = stayTime.poll();
                stayTime.offer(temp+1);
            }
        }
        return time;
    }
}
```
