import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int answer;
    public static boolean[] visit;
    public static HashSet<String> hs;
    public static StringBuilder sb;
    public static int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        ArrayList<ArrayList<Integer>> mappingSets = new ArrayList<>();
        for(int i = 0; i< banned_id.length;i++){
            ArrayList<Integer> mappingSet = new ArrayList<>();
            for(int j = 0; j<user_id.length;j++){
                if(ismapped(banned_id[i],user_id[j])){
                    mappingSet.add(j);
                }
            }
            mappingSets.add(mappingSet);
        }
        visit = new boolean[user_id.length];
        hs = new HashSet<>();
        sb = new StringBuilder();
        dfs(mappingSets,visit,0);
        return hs.size();
    }
    public static boolean ismapped(String banned_id, String target_id){
        if(banned_id.length()!=target_id.length())return false;
        for(int i = 0; i<banned_id.length();i++){
            if(banned_id.charAt(i)!='*'){
                if(banned_id.charAt(i)==target_id.charAt(i)) continue;
                else return false;
            }
        }
        return true;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> mappingSets, boolean[] visit, int SetIndex){
        if(SetIndex==mappingSets.size()) {
                String input = sb.toString();
               char[] insert =  input.toCharArray();
               Arrays.sort(insert);
               String sorted = new String(insert);
               hs.add(sorted);
            return;}

        ArrayList<Integer> mappingSet = mappingSets.get(SetIndex);
        for(int i = 0; i<mappingSet.size();i++){
            if(!visit[mappingSet.get(i)]){
                visit[mappingSet.get(i)] = true;
                sb.append(mappingSet.get(i));
                dfs(mappingSets,visit,SetIndex+1);
                visit[mappingSet.get(i)] = false;
                sb.deleteCharAt(SetIndex);
            }
        }
    }
    }
