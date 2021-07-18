### 우선순위 큐(Priority Queue)란?
PriorityQueue는 먼저 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고 그 우선순위가 높은 엘리먼트가 먼저 나가는 구조              
우선순위 큐는 힙을 이용하여 구현하는 것이 일반적             
데이터를 삽입할 때 우선순위를 기준으로 최대힙 혹은 최소 힙을 구성하고 데이터를 꺼낼 때 루트 노드를 얻어낸 뒤 루트 노드를 삭제할 때는            
빈 루트 노드 위치에 맨 마지막 노드를 삽입한 후 아래로 내려가면서 적절한 자리를 찾아서 옮기는 방식으로 진행                

### 우선순위 큐의 특징
**********************************
1. 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조 (큐에 들어가는 원소는 비교가 가능한 기준이 있어야함)            
2. 내부 요소는 힙으로 구성되어 이진트리 구조로 이루어져 있음                   
3. 내부구조가 힙으로 구성되어 있기에 시간 복잡도는 O(NLogN)              
4. 응급실과 같이 우선순위를 중요시해야 하는 상황에서 쓰임                 

### 우선순위 큐 사용하기
**************************************
#### 우선순위 큐 선언
```java
import java.util.PriorityQueue; //import

//int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

//int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
```

#### 우선순위 값 추가 및 삭제 
```java
priorityQueue.add(1);     // priorityQueue 값 1 추가
priorityQueue.peek();       //priorityQueue에 첫번째 값을 반환하고 제거하지는 않음 
priorityQueue.poll();       // priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
priorityQueue.remove();     // priorityQueue에 첫번째 값 제거
priorityQueue.clear();      // priorityQueue에 초기화
```
#### 값 추가할 때 자동적으로 이루어지는 과정             
![img](https://user-images.githubusercontent.com/84822464/126063471-eea06dbd-418d-4cea-9916-222c3ac66c7c.png)                           

#### 값 제거할 때 자동적으로 이루어지는 과정                         
![다운로드](https://user-images.githubusercontent.com/84822464/126063484-48da1d3f-7c15-4a27-a37c-66e1bb1e5141.png)                  

 

