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
