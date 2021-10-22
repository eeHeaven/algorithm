import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        HashMap<Integer, ArrayList<String>> hm = new HashMap<>();

        for(String s: words) {
            ArrayList<String> value;
            if (hm.containsKey(s.length())) {
               value = hm.get(s.length());
            } else {
                value = new ArrayList<>();
            }
            value.add(s);
            hm.put(s.length(), value);
        }
        int index = 0;
        for(String query: queries){
            int length = query.length();
            ArrayList<String> targets = hm.get(length);
            if(targets==null) {answer[index] = 0; index++; continue;}
            if(query.charAt(0)=='?'&&query.charAt(query.length()-1)=='?'){
               answer[index] = targets.size();
            }
            else if(query.charAt(0)=='?'&&query.charAt(query.length()-1)!='?'){
                int start = 0;
                int finish = dfs1(0,query.length(),query);
                int count = 0;
                for(String target: targets){
                    String temp=target.substring(finish+1,query.length());
                    if(query.substring(finish+1,query.length()).equals(temp)) count++;
                }
                answer[index] = count;
            }
            else if(query.charAt(0)!='?'&&query.charAt(query.length()-1)=='?'){
                int start = dfs2(0, query.length(), query);
                int finish = query.length()-1;
                int count = 0;
                for(String target: targets){
                    String temp=target.substring(0,start);
                    if(query.substring(0,start).equals(temp)) count++;
                }
                answer[index] = count;
            }
            index++;
        }
        return answer;
    }

    public static int dfs1(int s, int f, String query){
        int result =0;
        if(query.charAt((s+f)/2)=='?'&&query.charAt((s+f)/2+1)!='?'){
            return (s+f)/2;
        }
        else if(query.charAt((s+f)/2)=='?'&&query.charAt((s+f)/2+1)=='?'){
            result = dfs1((s+f)/2+1,f,query);
        }
        else result = dfs1(s,(s+f)/2,query);
        return result;
    }

    public static int dfs2(int s, int f, String query){
        int result =0;
        if(query.charAt((s+f)/2)=='?'&&query.charAt((s+f)/2-1)!='?'){
            return (s+f)/2;
        }
        else if(query.charAt((s+f)/2)=='?'&&query.charAt((s+f)/2-1)=='?'){
            result = dfs2(s,(s+f)/2,query);
        }
        else result = dfs2((s+f)/2+1,f,query);
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(solution(words,queries));
    }
}
