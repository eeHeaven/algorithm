import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static int[] banidmap;
    static int userNum;
    static int bannedNum;
    static boolean[] visit;

    public static void main(String[] args) {
        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id= {"fr*d*", "abc1**"};
        solution(userId,banned_id);


    }
    public static int solution(String[] user_id, String[] banned_id) {
        bannedNum = banned_id.length;
        userNum = user_id.length;
        visit = new boolean[banned_id.length];
        banidmap = new int[banned_id.length];
        int index = 0;
        HashSet<String> words = new HashSet<>();
        for(String s: banned_id){
            for(int j = 0; j<s.length();j++){
                if((s.charAt(j)<='z'&&s.charAt(j)>='a')||s.charAt(j)<='9'&&s.charAt(j)>='0'){
                  words.add(Character.toString(s.charAt(j)));
                }
            }
            for(String word: words){
                s = s.replaceAll(word,"["+word+"]");
            }

            String pattern = s.replaceAll("\\*",".");
            for(int i = 1; i<=user_id.length;i++){
                if(Pattern.matches(pattern,user_id[i-1])){
                    banidmap[index]|= (1 << i);
                }
            }
            index++;
        }
        dfs(0,1,0);
        int answer = set.size();

        return answer;
    }
    public static void dfs(int count, int start, int bit){
        if(count == banidmap.length){
            set.add(bit);
            return;
        }
        for(int i = start; i<=userNum;i++){
            for(int j = 0; j<bannedNum;j++){
                if(((banidmap[j] & (1 << i)) == (1 << i))&&!visit[j]){
                    visit[j] = true;
                    dfs(count+1,i+1,bit|=(1<<i));
                    visit[j] = false;
                    bit &= ~(1<<i);
                }
            }
        }

    }
}
