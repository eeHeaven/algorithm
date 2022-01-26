import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int result = 0;
    static HashMap<Character,Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
      String input = br.readLine();
      n = Integer.parseInt(input);

      for(int i =0;i<n;i++){
          String next = br.readLine();
          wordAnalyze(next);
      }
      List<Character> keySetList = new ArrayList(hm.keySet());
      Collections.sort(keySetList,(o1,o2)->(hm.get(o2).compareTo(hm.get(o1))));
      int num = 9;
      for(Character key: keySetList){
          result += hm.get(key)*num;
          num--;
      }
        System.out.println(result);

    }

    public static void wordAnalyze(String word){
        int length = word.length();
        for(int i = 0;i <length;i++){
            int num = (int)Math.pow(10,length-i-1);
            hm.put(word.charAt(i),hm.getOrDefault(word.charAt(i),0)+num);
        }
    }
}
