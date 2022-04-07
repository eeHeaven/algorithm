import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class solution {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        String t = br.readLine();
        int T = Integer.parseInt(t);
        for(int i = 0; i<T;i++){
          int N = Integer.parseInt(br.readLine());
          String s = br.readLine();
         if(N>1) sb.append("Case #"+(i+1)+": "+replaceWholeString(s)+"\n");
         else sb.append("Case #"+(i+1)+": "+s+"\n");
        }
        System.out.println(sb.toString());

    }

    public static String replaceWholeString(String s){
        boolean replaceflag = true;
        while(replaceflag == true) {
            replaceflag = false;
            for (int firstnum = 0; firstnum <= 9; firstnum++) {
              ReturnSet returnSet =  replaceNumber(s,replaceflag,0,firstnum);
              s = returnSet.s;
              replaceflag = returnSet.flag;
              if(s.length() ==1) return s;
            }
        }
        return s;
    }

    public static ReturnSet replaceNumber(String s, boolean replaceflag, int index, int num){
        int secondnum = (num+1)%10;
        if(s.charAt(index) ==  Character.forDigit(num,10) && s.charAt(index+1) ==  Character.forDigit(secondnum,10)){
            s = s.substring(0,index)+ Integer.toString((num+2)%10)+s.substring(index+2,s.length());
            replaceflag = true;
        }
        if((index+1 <s.length()-1)) return replaceNumber(s,replaceflag,index+1,num);
        else return new ReturnSet(s,replaceflag);
    }
}
class ReturnSet{
    String s;
    boolean flag;

    public ReturnSet(String s, boolean flag) {
        this.s = s;
        this.flag = flag;
    }
}
