import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public static HashSet<Long> hs = new HashSet<>();
    public static long bit = 0;
    public int solution(String[] user_id, String[] banned_id) {
        ArrayList<ArrayList<Integer>> mapSet = new ArrayList<>();
        for(String s:banned_id){
            ArrayList<Integer> map = new ArrayList<>();
            for(int i = 0; i<user_id.length;i++){
                if(isMapped(s,user_id[i])){
                    map.add(i);
                }
            }
            mapSet.add(map);
        }
        boolean[] visit = new boolean[user_id.length];
        dfs(mapSet,visit,0);
        return hs.size();
    }

   public static boolean isMapped(String banned_id, String target_id){
        if(banned_id.length()!=target_id.length())return false;
        for(int i = 0; i<banned_id.length();i++){
            if(banned_id.charAt(i)!='*'){
                if(banned_id.charAt(i)==target_id.charAt(i)) continue;
                else return false;
            }
        }
        return true;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> mapSets, boolean[] visit, int setIndex){
        if(setIndex==mapSets.size()){
            hs.add(bit);
            return;
        }
        ArrayList<Integer> map = mapSets.get(setIndex);
        for(int i = 0; i<map.size();i++){
            if(!visit[map.get(i)]){
                visit[map.get(i)] = true;
                bit|=(1<<map.get(i));
                dfs(mapSets,visit,setIndex+1);
                visit[map.get(i)] = false;
                bit&=~(1<<map.get(i));
            }
        }
        
    }
}
