import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;
    static int n ;
    static int k;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] inputs = input.split(" ");
        n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] value = new int[100001]; // n에서 부터 각 index까지 가는데 걸리는 시간 count 값

        q.add(n);
        visited[n] = true;
        value[n] = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            count = value[temp];
            if (temp == k) {
                System.out.println(count);
                return;
            }
            if(temp+1 <=100000){if (!visited[temp + 1]) {visited[temp+1] = true; q.add(temp + 1); value[temp+1] = count+1;}}
            if(temp-1>=0){if (!visited[temp - 1]) {visited[temp-1] = true; q.add(temp - 1); value[temp-1] = count+1;}}
            if(temp*2 <=100000){if (!visited[temp * 2]) {visited[temp*2] = true; q.add(temp * 2); value[temp*2] = count+1;}}
        }


    }}
