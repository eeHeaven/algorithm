# 프로그래머스 코딩테스트 연습 해시문제 

## 전화번호 목록 문제 
> 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.   
구조대 : 119   
박준영 : 97 674 223   
지영석 : 11 9552 4421   
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**1. string1.startsWith(string2)**   
string1이 string2로 시작하는지 비교하여 boolean 값을 return 하는 함수 

**2. 해시맵.containsKey(문자열)**   
해시맵 key값에 문자열이 있는지 확인하여 boolean 값을 return 하는 함수 

**3. 문자열.subString(int 1,int 2)**  
문자열을 원하는 범위 내로 잘라내는 함수   
int 1 자리의 문자부터 int 2 자리의 문자 직전까지 잘라냄     

************************************


* 문제 풀이 코드 
  - sort/loop 를 사용한 풀이 
```java
class Solution { 

  public boolean solution(String[] phoneBook) {
  
    for(int i=0; i<phoneBook.length-1; i++) {
      for(int j=i+1; j<phoneBook.length; j++) {
        if(phoneBook[i].startsWith(phoneBook[j])) {return false;} 
        if(phoneBook[j].startsWith(phoneBook[i])) {return false;} 
        }
      } return true; 
   } 
 }
```
  - hash 를 사용한 풀이 
```java
import java.util.HashMap; import java.util.Map;


class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < phone_book.length; i++) map.put(phone_book[i], i);
        for(int i = 0; i < phone_book.length; i++) { 
          for(int j = 1; j < phone_book[i].length(); j++) { 
            if(map.containsKey(phone_book[i].substring(0,j))) { answer = false; return answer; } } }

        

 return answer;

    }
}
```
