# 프로그래머스 코딩테스트 연습 정렬문제 

## H-index 문제 
> H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.      
어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.       
어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.        

* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**이 문제는 문제 접근에 좀 더 시간을 쏟았으면 좋았을 걸!**      
1. 문제를 해석하고 예외를 처리하는 과정에 좀 더 많은 공을 들이자.        
2. 단순하게 생각하고 주어진 숫자(결과값)들의 관계에 집중할 것           

**문제 접근 방식**         
1. 이 문제의 핵심은, 인용 횟수에 따른 인용된 논문의 편 수는 인용 횟수를 오름차순으로 정렬했을 때 중복값 제외 전체 값의 길이에서 자신의 인덱스 값만큼 빠진 값이라는 것이다.       
2. 이 규칙 하나만 찾아내면 알고리즘은 매우 간단해진다.          


************************************


* 문제 풀이 코드 
```java
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
```
