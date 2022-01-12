import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int l;
  static int c;
  static ArrayList<Character> vowel = new ArrayList<>();
  static ArrayList<Character> cons = new ArrayList<>();
  static ArrayList<Character> alphabet = new ArrayList<>();
  static boolean[] visit;
  static TreeSet<String> pw = new TreeSet<>();
  static char[] sb;
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오기
        String input = br.readLine();
       String[] lc = input.split(" ");
        l = Integer.parseInt(lc[0]);
        c = Integer.parseInt(lc[1]);
        sb = new char[l];
        visit = new boolean[c];
        String next = br.readLine();
        String[] alphabets = next.split(" ");
        int index =0;
        for(String alpha:alphabets){
            char a = alpha.toCharArray()[0];
            switch(a){
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    vowel.add(a);
                    break;
                default:
                    cons.add(a);
                    break;
            }
            alphabet.add(a);
        }
        for(char v: vowel){
            visit[alphabet.indexOf(v)] = true;
            sb[0] = v;
            dfs(2,1,0,0);
            visit[alphabet.indexOf(v)] = false;
        }

        Iterator it = pw.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    public static void dfs(int c, int length, int start1, int start2){
        if(length==l){
            //사전순 sort
            char[] temp = new char[l];
            int i = 0;
            for(char ch: sb){
                temp[i++] = ch;
            }
            Arrays.sort(temp);
            //Treeset에 넣기
            pw.add(new String(temp));
            return;
        }
        if(c == 0){
            for(int i = start2; i<alphabet.size();i++){
                if(visit[i]==false){
                visit[i] = true;
                sb[length] = alphabet.get(i);
                dfs(c,length+1,start1,i+1);
                visit[i] = false;
            }}}
            else{
              for(int i = start1; i<cons.size();i++){
                  char thiscons = cons.get(i);
                  visit[alphabet.indexOf(thiscons)] = true;
                  sb[length] = thiscons;
                  dfs(c-1,length+1,i+1,start2);
                  visit[alphabet.indexOf(thiscons)] = false;
            }
        }
    }
     }
