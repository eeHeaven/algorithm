import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    static String function;
    static StringTokenizer numbers;
    static StringBuilder sd = new StringBuilder();
    static StringBuilder sd2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(br.readLine());

        for(int i = 0; i<tests; i++){
            int size;
            function =br.readLine();
            size =  Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            numbers = new StringTokenizer(br.readLine(),"[],");
            sd2 = new StringBuilder();
            for( int j = 0; j< size;j++){
                int key = Integer.parseInt(numbers.nextToken());
                arr.add(key);
            }
            AC(arr,function);



        }
        System.out.println(sd);

    }

    public static void AC(ArrayList<Integer> arr, String function){
        boolean back = false;
        for(int j = 0;j<function.length();j++){
            if(function.charAt(j) =='R'){
                back = !back;
                continue;
            }
            if(function.charAt(j) =='D'){
                if(arr.isEmpty()) {sd.append("error\n"); return;}
                else{
                    if(back == false) arr.remove(0);
                    if(back == true) arr.remove(arr.size() -1);
                    }
            }
        }
        printresult(arr,back);
    }

    public static void printresult(ArrayList<Integer> arr, boolean back){
        sd.append("[");
        if(arr.size()!=0)
        {
            if(arr.size()== 1) sd.append(arr.get(0));
            else if(back == false){
            for(int j = 0; j<arr.size()-1;j++){
                sd.append(arr.get(j)).append(",");
            }
            sd.append(arr.get(arr.size()-1));
        }
        else if(back == true){
            for(int j =arr.size()-1; j>=1;j--){
                sd.append(arr.get(j)).append(",");
            }
            sd.append(arr.get(0));
        }}
        sd.append("]\n");
    }


}
