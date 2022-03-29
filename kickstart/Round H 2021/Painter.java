import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.HashMap;

class solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int count = 0;
    static HashMap<Character,String> colormap = new HashMap<>();
    public static void main(String[] args) throws IOException{
        String test = br.readLine();
        T = Integer.parseInt(test);

        colormap.put('U',"");
        colormap.put('R',"R");
        colormap.put('Y',"Y");
        colormap.put('B',"B");
        colormap.put('G',"YB");
        colormap.put('O',"RY");
        colormap.put('P',"RB");
        colormap.put('A',"RBY");

        for(int i = 0; i<T;i++) {
            String n = br.readLine();
            N = Integer.parseInt(n);
            String P = br.readLine();
            count = 0;
            getSolution(P);
            sb.append("Case #"+(i+1)+": "+count+"\n");
        }
        System.out.println(sb.toString().substring(0,sb.length()-1));
    }
    public static void getSolution(String P){
        paintEachColor(P,"R");
        paintEachColor(P,"Y");
        paintEachColor(P,"B");
    }
    public static void paintEachColor(String P,String color){
        boolean flag = false;
        boolean prevflag = false;
        for(int i = 0; i<P.length();i++){
            if(colormap.get(P.charAt(i)).contains(color)) flag = true;
            else flag = false;
            if(flag!=prevflag && flag == true){
                count++;
            }
            prevflag = flag;
        }
    }
}
