# 프로그래머스 Hash 문제 정리

## 베스트 앨범 문제 

* 문제
> 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.    
속한 노래가 많이 재생된 장르를 먼저 수록합니다.    
장르 내에서 많이 재생된 노래를 먼저 수록합니다.    
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.    
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,     
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.     
    
    
    
* 문제 풀이에 사용되는(필요한) method들/기타 문법 주의사항  
******************
**1. ArrayList**     
선언 시 따로 크기 선언 필요 없이 입력되는 데이터에 따라 배열의 크기가 유동적인 list      
**set의 경우 중복 불가, 순서대로 저장 불가** 인데, ArrayList는 중복허용+ 순서대로(index) 저장 가능     
     
     - ArrayList 선언
     ArrayList < 자료형 > list = new ArrayList < 자료형 >(); //자료형에 클래스도 가능 
     
     - 값 추가
     list.add(값); list.add(null); // null값도 add 가능
     list.add(1,값); // 1번 index 뒤에 값 넣음 
     
     - 값 삭제
     list.remove(1); // index 1 제거 
     list.clear(); // 모든 값 제거 
     
     - ArrayList의 크기
     list.size();
     
     - 값 검색
     list.contains(1); //list에 1이 있는지 boolean으로 return
     list.indexOf(1); // 1이 있는 index 번호를 return, 없으면 -1 return 

**2. Collections - sort메서드**     
Collections 클래스는 주로 데이터를 정렬할때 사용    

        - Collections.sort()    
    매개변수를 무조건 List 자료형만 받음
    List 자료형의 재네릭이 class인 경우 해당 class는 Comparable을 implements 해야함 
    해당 class에서 compareTo override 하기 (a.compareTo(b) -> a - b: 오름차순/ b.comparteTo(a): 내림차순)
    
    - sort메서드의 input인자에서 new Comparator선언 후 compare override하기
    Collections.sort(list, new Comparator(){
    public int compare(Object o1, Object o2){
    Object v1 = map.get(o1);
    Object v2 = map.get(o2);
    
    return ((Comparable)v2).compareTo(v1); // 내림차순 정렬
    }});
    
    - 그러나 요즘에는 그냥 list.sort(comparator) 형태로 간편화됨
    list.sort((o1,o2)->map.get(o2).compareTo(map.get(o1)));
    
****************************************



* 문제 풀이 
  - List.sort와 ArrayList를 활용한 풀이 
```java

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> arrAnswer = new ArrayList<Integer>();
        HashMap<String,Integer> hmGenres = new HashMap<>();
        for(int i = 0; i<genres.length;i++){
            hmGenres.put(genres[i],hmGenres.getOrDefault(genres[i],0) + plays[i]);
        }
        List<String> keySetList = new ArrayList<>(hmGenres.keySet());
        Collections.sort(keySetList, new Comparator(){public int compare(Object o1, Object o2){
            Object v1 = hmGenres.get(o1);
            Object v2 = hmGenres.get(o2);

            return ((Comparable)v2).compareTo(v1);
        }});

        for(String key : keySetList){
            HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
            for(int i =0; i<genres.length;i++){
                if(key.equals(genres[i])){
                    hs.put(i,plays[i]);
                }
            }

        List<Integer> keyLists = new ArrayList<>(hs.keySet());
            keyLists.sort((s1,s2)->hs.get(s2).compareTo(hs.get(s1)));
            int j = 0;
            for( Integer c: keyLists){
                if(j>1) break;
                arrAnswer.add(c);
                j++;
            }
        }
        answer = new int[arrAnswer.size()];
        for(int i = 0; i<arrAnswer.size();i++){
            answer[i] = arrAnswer.get(i);
        }
        return answer;
    }
}
  ```
