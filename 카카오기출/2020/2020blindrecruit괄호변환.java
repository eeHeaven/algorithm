import java.io.StringBufferInputStream;
import java.util.Stack;

class Solution {
   static String answer = "";
    public static String solution(String p) {
        answer = dfs(p);
        return answer;
    }

    public static String dfs(String p){
        if(isRight(p)) return p;
        if(p=="") return p;
        int leftcount =0;
        int rightcount = 0;
        int index =0;
        while(leftcount!=rightcount||leftcount<=0||rightcount<=0){
            if(p.charAt(index)=='('){
                leftcount++;
                index++;
            }
            else if(p.charAt(index)==')'){
                rightcount++;
                index++;
            }
            if(leftcount>=1&&rightcount>=1&&leftcount==rightcount) break;
        }
        String u = p.substring(0,leftcount*2);
        String v = p.substring(leftcount*2,p.length());

        if(isRight(u)){
            return u+dfs(v);
        }
        else{
            String last = u.substring(1,u.length()-1);
            String fin ="";
            for(int i = 0; i<last.length();i++){
                switch(last.charAt(i)){
                    case '(':
                        fin= fin+")";
                        break;
                    case ')':
                        fin = fin+"(";
                        break;
                }
            }
            return "("+dfs(v)+")"+ fin;
        }
    }

    public static boolean isRight(String p){
        Stack<Character> st = new Stack<>();
        for(int i =0; i<p.length();i++){
            char key = p.charAt(i);
            if(!st.isEmpty()){
            if(key ==')'&& st.peek()=='('){
                st.pop();
                continue;
            }
            else st.push(key);
        }
           else st.push(key);
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}
