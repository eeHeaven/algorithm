# 프로그래머스 코딩테스트 연습 해시문제 

## 전화번호 목록 문제 
> 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.    
예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.      
얼굴:	동그란 안경, 검정 선글라스    
상의:	파란색 티셔츠    
하의:	청바지    
겉옷:	긴 코트    
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요. solution 함수를 작성해주세요.    

* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**1. 해시맵.getOrDefault(key문자열,default값-int형)**   
해시맵에서 key값에 해당하는 value값을 가져오되, 만약 key값이 없다면 null이 아닌 default값을 가져오게 하는 함수 

**2. Iterator 정의**    
Iterator란 HashMap 과 같은 데이터set에 있는 데이터를 순차적으로 접근하기 위해 사용하는 dataset   
Iterator는 자료를 각각 하나의 객체로 저장하고 있기 때문에 나중에 값을 꺼낼때는 형변환이 반드시 필요하다.   

**2-1. Iterator 정의 방법**   
Iterator < Integer > it  = 해시맵.values() *혹은 다른 데이터 set* .iterator();    

**3. Iterator 사용법**  
while(it.hasNext()) -> Iterator에 들어온 자료set을 처음부터 끝까지 방문    
it.next() -> Iterator의 다음 객체 return (처음 시작 시 it.next()는 첫 객체를 리턴한다)     
it.remove() -> 객체를 제거   

**4. Iterator 값 리턴시 형변환 method**    
it.next().intValue()   
int형태로 값을 변환해서 return    

************************************


* 문제 풀이 코드 
  - hash 를 이용한 풀이 
```java
import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap < String, Integer> map = new HashMap<>();
        String s;
        
        for(int i =0; i< clothes.length; i++){
        s = clothes[i][1];
            if(map.get(s)!=null){
                map.put(s,map.get(s) + 1);
            }
            else {map.put(s,1);}
            
        }
            
        
        Iterator<Integer> it = map.values().iterator();
    while(it.hasNext()){
        answer *= it.next().intValue() + 1;
    }
        
       
    return answer - 1;
    }}
```
