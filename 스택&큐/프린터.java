import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> loc = new LinkedList<>();
        int[] order = new int[priorities.length];
        Integer[] arr = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Comparator.reverseOrder());
        int maxindex = 0;



        for(int i = 0; i<priorities.length;i++){
            q.offer(priorities[i]);
            loc.offer(i);}

        while(!q.isEmpty()){
                if(q.peek()<arr[maxindex]){
                    q.offer(q.poll());
                    loc.offer(loc.poll());}
                else{
                    q.poll();
                    order[maxindex] = loc.poll();
                    maxindex++;
                }
            }
        for(int i = 0; i<order.length;i++) {
            if (order[i] == location)
                return (i + 1);
        }
        return -1;
        }


    }
