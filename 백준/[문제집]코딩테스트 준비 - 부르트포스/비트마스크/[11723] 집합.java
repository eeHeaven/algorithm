import java.io.*;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int m;
    static boolean[] bit = new boolean[21];


    public static void main(String[] args) throws Exception {

        String input = br.readLine();
        m = Integer.parseInt(input);
        for(int i = 0; i<m;i++){
            String order = br.readLine();
            StringTokenizer st = new StringTokenizer(order);
            int num;
            switch (st.nextToken()){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    bit[num] = true;
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bit[num] = false;
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if(bit[num]) bw.append(1+"\n");
                    else bw.append(0+"\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if(bit[num]) bit[num] = false;
                    else bit[num] = true;
                    break;
                case "all":
                    for(int j =1;j<=20;j++)bit[j] = true;
                    break;
                case "empty":
                    for(int j =1;j<=20;j++)bit[j] = false;
                    break;
            }


        }
        bw.flush();
        bw.close();
        
    }
}
