import java.io.*;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static ArrayList<Integer> dequeue = new ArrayList<>();


    public static void main(String[] args) throws Exception {

        String input = br.readLine();
        n = Integer.parseInt(input);

        for(int i = 0; i<n;i++){
            String next = br.readLine();
            StringTokenizer st = new StringTokenizer(next);
            int num;
            switch(st.nextToken()){
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    dequeue.add(0,num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    dequeue.add(dequeue.size(),num);
                    break;
                case "pop_front":
                    if(dequeue.isEmpty())bw.append(-1+"\n");
                    else bw.append(dequeue.remove(0).toString()+"\n");
                    break;
                case "pop_back":
                    if(dequeue.isEmpty())bw.append(-1+"\n");
                    else bw.append(dequeue.remove(dequeue.size()-1).toString()+"\n");
                    break;
                case "size":
                    bw.append(Integer.toString(dequeue.size())+"\n");
                    break;
                case "empty":
                    if(dequeue.isEmpty())bw.append(1+"\n");
                    else bw.append(0+"\n");
                    break;
                case "front":
                    if(dequeue.isEmpty())bw.append(-1+"\n");
                    else bw.append(dequeue.get(0).toString()+"\n");
                    break;
                case "back":
                    if(dequeue.isEmpty())bw.append(-1+"\n");
                    else bw.append(dequeue.get(dequeue.size()-1).toString()+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();

    }
}
