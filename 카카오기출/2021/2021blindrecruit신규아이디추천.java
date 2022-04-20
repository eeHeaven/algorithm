class Solution {
    public static String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int dotcount = 0;
        for (int i = 0; i < new_id.length(); i++) {
            char key = new_id.charAt(i);
            if (('a' <= key && key <= 'z') || ('0' <= key && key <= '9') || key == '-' || key == '_' || key == '.')
                sb.append(key);
            else if ('A' <= key && key <= 'Z') {key = (char) (key + 32); sb.append(key);}
        }

        String temp = sb.toString();
        while(temp.contains("..")){
            temp = temp.replace("..",".");
        }
        if(temp.charAt(0)=='.') temp = temp.substring(1,temp.length());
        if(temp.length()>=1&&temp.charAt(temp.length()-1)=='.') temp = temp.substring(0,temp.length()-1);
        if(temp.length() ==0) return "aaa";
        if(temp.length()>=16) {temp = temp.substring(0,15); if(temp.charAt(14)=='.') temp= temp.substring(0,14);}
        while(temp.length()<3){ temp = temp.concat(Character.toString(temp.charAt(temp.length()-1)));}
        answer = temp;

        return answer;
    }
}
