import java.util.HashMap;

class Solution {
    public static int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String,Integer> hm1 = new HashMap<>();
        HashMap<String,Integer> hm2 = new HashMap<>();
        int join = 0;
        int plus = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for(int i =0; i< str1.length()-1;i++){
            String word = str1.substring(i,i+2);
            if(('a'<=word.charAt(0)&&'z'>=word.charAt(1))&&('z'>=word.charAt(0)&&'a'<=word.charAt(1))){
                hm1.put(word,hm1.getOrDefault(word,0)+1);
            }
            else continue;
        }
        for(int i =0; i< str2.length()-1;i++){
            String word = str2.substring(i,i+2);
            if(('a'<=word.charAt(0)&&'z'>=word.charAt(1))&&('z'>=word.charAt(0)&&'a'<=word.charAt(1))){
                String rword = word.toLowerCase();
                hm2.put(rword,hm2.getOrDefault(rword,0)+1);
            }
            else continue;
        }

        if(hm1.isEmpty()&&hm2.isEmpty()) return 65536;

        for(String key:hm1.keySet()){
            if(hm2.containsKey(key)){
                join+=Integer.min(hm1.get(key),hm2.get(key) );
                plus+=Integer.max(hm1.get(key),hm2.get(key) );
            }
            else plus+=hm1.get(key);
        }
        for(String key: hm2.keySet()){
            if(hm1.containsKey(key)) continue;
            else plus+=hm2.get(key);
        }

        answer = (int) Math.floor(((double)join/plus)*65536);
        return answer;
    }
}
