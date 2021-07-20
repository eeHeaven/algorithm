# 프로그래머스 코딩테스트 연습 힙문제 

## 디스크 컨트롤러 
>하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.             
>예를들어                 
>- 0ms 시점에 3ms가 소요되는 A작업 요청                     
>- 1ms 시점에 9ms가 소요되는 B작업 요청                     
>- 2ms 시점에 6ms가 소요되는 C작업 요청     
>                      
>와 같은 요청이 들어왔습니다. 이를 그림으로 표현하면 아래와 같습니다.    
<img width="693" alt="38dc6a53-2d21-4c72-90ac-f059729c51d5" src="https://user-images.githubusercontent.com/84822464/126313910-b756b72f-4b0c-4b98-8d0f-bbb21896e205.png">
<img width="676" alt="a6cff04d-86bb-4b5b-98bf-6359158940ac" src="https://user-images.githubusercontent.com/84822464/126313912-b1047c52-ca1a-422f-b5bb-5e41a57372ba.png">

>이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.                  
>각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,             
>작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)     

          

                               
                        
* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**일단 문제 해석은 잘 했고 식도 잘 짰음! 코드 구현이 문제였던 것**            
내가 대략적인 풀이를 짜고 구현하고자 했을 때 가장 막혔던 부분이               
**2차원 배열(Map형태로)을 어떻게 priorityQueue에 넣나** 였다.              
input값인 jobs의 각 column의 첫번째 index와 두번째 index 둘 다를 고려하여 첫번째 인덱스를 우선순위로 놓고 같은 크기인 경우 두번째 인덱스의 크기를 고려하여               
PriorityQueue에 넣고 싶은데 그걸 구현 못했다.               
이때 사용할 수 있는 방법은           
**jobs를 각 column의 첫번째 index를 기준으로 오름차순으로 정렬한 뒤             
jobs의 index값을 하나하나 방문하여 원하는 범위에 있는 정수배열(column값)을 두번째 인덱스를 우선순위 기준으로 priorityQueue에 넣는것**              


**PriorityQueue 생성자에서 Comparator 활용하기**            
PriorirtyQueue<int[]> qp = new PriorityQueue<>((o1,o2)->o1[1] - o2[1]);             
Comparator 활용 때에는 알다시피 **오름차순일때는 o1-o2/ 내림차순일때는 o2-o1**           
**Comparator는 2차원배열 Arraysort에서도 활용할 수 있음**                      


************************************


* 문제 풀이 코드 
```java
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	public int solution(int[][] jobs) {

		int answer = 0;
		int end = 0; // 수행되고난 직후의 시간
		int jobsIdx = 0; // jobs 배열의 인덱스
		int count = 0; // 수행된 요청 갯수

		// 원본 배열 오름차순 정렬 (요청시간 오름차순)
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		// 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		// 요청이 모두 수행될 때까지 반복
		while (count < jobs.length) {

			// 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
			while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
				pq.add(jobs[jobsIdx++]);
			}

			// 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
			// (end를 요청의 가장 처음으로 맞춰줌)
			if (pq.isEmpty()) {
				end = jobs[jobsIdx][0];

			// 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
			} else {

				int[] temp = pq.poll();
				answer += temp[1] + end - temp[0];
				end += temp[1];
				count++;
			}
		}

		return (int) Math.floor(answer / jobs.length);
	}
}
```
