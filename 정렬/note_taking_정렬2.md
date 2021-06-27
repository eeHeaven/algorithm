# 프로그래머스 코딩테스트 연습 정렬문제 

## 전화번호 목록 문제 
> 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.    
예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.     
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.   

* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항
*******************************
**1. compare 메서드와 sort**     
compare 메서드의 리턴 값은 음수, 양수, 0이 될 수 있다.      
**음수가 리턴되면 오른쪽 인자가 아래로 내려간다.**      
```java
Collections.sort(strings, new Comparator<String>(){
public int compare(String s1, String s2){
return s1.length()-s2.length();}
});
```
s1의 길이가 더 작아서 return 값이 음수가 되면 s2가 아래로 내려감 -> 오름차순 

**2. Comparable과 Comparator의 차이점**     
Comparable은 인터페이스로, 이 인터페이스를 클래스가 구현하면 리스트 등을 정렬하는데 사용 가능.     
Comparator는 정렬에 대한 규칙을 갖고있는 클래스. 보통 한 번만 사용하고 안쓰기 때문에 sort메서드 안에서 익명 객체로 만들어짐.

**3. 문자열 비교**       
String a - String b 의 결과값에서       
a가 b와 같다면 0 return      
b가 a의 일부로 포함되어 있다면 a.length()-b.length() return        
a와 b가 다른 string이라면 아스키코드 차이 값 return       


************************************


* 문제 풀이 코드 
```java
 import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {

        String answer = "";
        String[] arr = new String[numbers.length];


        for (int i = 0; i < numbers.length; i++) {
            arr[i] = (String.valueOf(numbers[i]));    
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });

        if(arr[0].equals("0")) {
            return "0";
        }

        for(int i=0; i<arr.length; i++) {
            answer += arr[i];
        }

        return answer;
    }
}
```
