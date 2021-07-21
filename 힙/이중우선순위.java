import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int value;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //pq는 데이터 오름차순 
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());//데이터 내림차순 

        for(int i = 0; i<operations.length;i++){
            String [] each = operations[i].split(" "); // each[0]:연산자 each[1]:연산값
            if(each[0].equals("I")){//연산자가 I일 때 
                pq.add(Integer.parseInt(each[1]));
                pq2.add(Integer.parseInt(each[1]));
                continue;
            }
            if(each[0].equals("D")&&!pq.isEmpty()){ //연산자가 D이고 큐의 데이터가 비어있지 않을 때
                if(each[1].equals("1")){ //연산값이 1일 때 
                    value = pq2.poll(); // 최대값 제거 
                    pq.remove(value);
                }
                if(each[1].equals("-1")){ //연산값이 -1일 때 
                    value = pq.poll();//최소값 제거 
                    pq2.remove(value);
                }
                continue;
            }

        }
        if(!pq.isEmpty()){ //전체 큐에 데이터가 남아있을 때 
        answer[1] = pq.poll();
        answer[0] = pq2.poll();}
        else //전체 큐에 데이터가 없을 때 
        {answer[0] = 0; answer[1] = 0;}
        return answer;
    }
}
