import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[][] each = new int[N+1][2];
        for(int n: stages){
            int stage = n;
            each[n-1][0] += 1;
            while(stage>0){
                each[stage-1][1]+= 1;
                stage--;
            }
        }

        HashMap<Integer,Double> hm = new HashMap<>();
        for(int i=0; i<each.length-1;i++){
            double nonclear = (double)each[i][0];
            double clear = (double)each[i][1];
            double key = nonclear/clear;
            if(clear ==0) key =0.0;
            hm.put(i+1,key);
        }

        List<Map.Entry<Integer,Double>> list_entries = new ArrayList<Map.Entry<Integer,Double>>(hm.entrySet());

        // 비교함수 Comparator를 사용하여 내림 차순으로 정렬
        Collections.sort(list_entries, new Comparator<Map.Entry<Integer,Double>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<Integer,Double> obj1, Map.Entry<Integer,Double> obj2)
            {
                // 내림 차순으로 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        int i =0;
        for(Map.Entry<Integer,Double> entry : list_entries) {
            answer[i] = entry.getKey();
            i++;
        }

        return answer;
    }
}
