# 프로그래머스 Hash 문제 정리

## 완주하지 못한 선수 문제

* 문제
> 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다. 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
    
    
    
* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항  
******************
 **1. import Java.util.Arrays;**    
    Array 패키지를 import 시켜야 함

 **2. Arrays.sort(array명);**    
    Array sort를 위해 필요한 method 

**3. string1.equals(string2)**        
String이 같은지 비교하는 boolean 함수 

**4. length 와 length()의 쓰임**      
 length는 배열의 크기를 return 할 때 쓰는 함수    
 length()는 stirng(문자열)의 길이를 return 할 때 쓰는 함수    
 
**5. import java.util.HashMap;**   
Hash 사용을 위해 import 해야 하는 라이브러리 

**6. HashMap <String,Integer> map = new HashMap<>();**    
HashMap 정의 방식 

**7. for(String s: string 배열 명)**    
String 배열을 for loop로 한바퀴 도는 법 

**8. 해시맵.get(문자열)**    
해시맵에서 문자열과 동일한 key값을 찾아 그 value를 가져오는 함수    
만약 문자열과 동일한 key 값이 없을 시에는 **null 값**을 return 한다.
  
**9. 해시맵.put(string, int);**   
해시맵에 각 key값과 value값 삽입하기   
만일 동일한 key값이 이미 해시맵에 존재하는 경우, 자동적으로 최근 put 함수에서 제시한 value 값으로 해당 key에 대한 value값이 수정된다.   

**10. 해시맵.keySet()**   
해시맵의 keySet를 String 배열로 return    

****************************************



* 문제 풀이 
  - sorting/loop를 통해 푸는 방식
  
  ```java
  import java.util.Arrays;
  import java.util.HashMap;

  class Solution {
    public String solution(String[] participant, String[] completion) {
         String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i<completion.length; i++){
            if(!completion[i].equals(participant[i])) {answer = participant[i]; return answer;}
        }
        answer = participant[participant.length - 1];
        return answer;
    }
  }
  ```
  
  - 해시를 이용하는 방식 
  
  ```java
  import java.util.HashMap;
  import java.util.Arrays;

  public class Solution1_1 {
    String answer = "";
    HashMap <String,Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
      for(String p : participant) {
        if(map.get(p)!=null) {
          map.put(p, map.get(p)+1);
        }
        else map.put(p, 1);
      }

      for(String p : completion) {
        map.put(p, map.get(p) - 1);
      }

      for(String key : map.keySet()) {
        if(map.get(key)!= 0) {
          answer = key;
          break;
        }
      }

      return answer;
    }
  ```
