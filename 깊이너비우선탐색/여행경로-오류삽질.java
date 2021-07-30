import java.util.ArrayList;

class solution {

    static ArrayList<String> answers = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        String answer[] = new String[tickets.length + 1];
        boolean[] visit = new boolean[tickets.length];
        dfs("ICN", tickets, visit, "ICN ", tickets.length);
        answers.stream().sorted();
        answers.forEach(System.out::println);
        String finalroute = answers.get(0);
        answer = finalroute.split(" ");
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
                out = tickets[j][1];
                route = route.concat(out + " ");
                leftTicket--;
                dfs(out, tickets, visit, route, leftTicket);
                visit[j] = false;
            }


        }

    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        solution(tickets);
    }
