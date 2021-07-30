import java.util.ArrayList;
import java.util.Collections;

class Solution {

    static ArrayList<String> answers = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        String answer[] = new String[tickets.length + 1];
        boolean[] visit = new boolean[tickets.length];
        dfs("ICN", tickets, visit, "ICN ", tickets.length);
        Collections.sort(answers);                        //답들 중 가장 알파벳순이 빠른 배열들로 정렬
        answer = answers.get(0).split(" ");
        return answer;
    }

    public static void dfs(String out, String[][] tickets, boolean[] visit, String route, int leftTicket) {
        // System.out.println("out: "+out+" route: "+route);
        if (leftTicket == 0) {
            answers.add(route);
            return;
        }

        for (int j = 0; j < tickets.length; j++) {
            if (visit[j] == true) continue;
            if (out.equals(tickets[j][0])) {
                visit[j] = true;
                dfs(tickets[j][1], tickets, visit,route+tickets[j][1]+" ", leftTicket-1);
                visit[j] = false;

            }


        }
    }
}
