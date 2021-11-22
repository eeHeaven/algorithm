import java.util.*;

class Solution {
    static HashMap<String, Integer> map;// <key , value> = <String, counting개수>
    static int m;

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 0; i < course.length; i++) {//각각의 "요리의 개수"에 대하여 실행.
            map = new HashMap<>();//각 i일때마다 초기화!!!
            m = 0;
            for (int j = 0; j < orders.length; j++) {
                find(0, "", course[i], 0, orders[j]);
            }
            for (String s : map.keySet()) {//각 i일때마다 초기화되므로
                if (map.get(s) == m && m > 1) {//최대값m인 value를 가진 key값을 찾아서
                    pq.offer(s);//우선순위 큐에다가 집어넣는다.
                }
            }
        }
        String ans[] = new String[pq.size()];
        int k = 0;
        while (!pq.isEmpty()) {
            ans[k++] = pq.poll();
        }
        return ans;
    }

    static void find(int cnt, String str, int targetNum, int idx, String word) {
        if (cnt == targetNum) {
            char[] c = str.toCharArray();//문자열 하나하나에 대하여 알파벳순으로
            Arrays.sort(c);//정렬시킴.
            String temps = "";
            for (int i = 0; i < c.length; i++) //정렬한거 다시합치기
                temps += c[i];
            map.put(temps, map.getOrDefault(temps, 0) + 1);//각 음식세트 카운팅값.
            m = Math.max(m, map.get(temps));//map에다가 이렇게 넣으면서! 카운팅최대값을 미리 구해놓는다.
            return;
        }
        for (int i = idx; i < word.length(); i++) {
            char now = word.charAt(i);
            find(cnt + 1, str + now, targetNum, i + 1, word);
        }
    }
}
