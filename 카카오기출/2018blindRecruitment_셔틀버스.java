import java.util.*;

class Solution {
   static int[] bus;
   static PriorityQueue<Integer> line;
   static int time;
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int tempanswer = 0;
        bus = new int[n];
        for (int i = 0; i < n; i++) {
            bus[i] = 9 * 60 + (i * t);
        }

        int[] lines = new int[timetable.length];
        line = new PriorityQueue<>();
        for (int i = 0; i < timetable.length; i++) {
            String[] hm = timetable[i].split(":");
            int hour = Integer.parseInt(hm[0]);
            int min = Integer.parseInt(hm[1]);

            line.add(hour * 60 + min);
        }

        int i = 0;
        int count = 0;
        int time;
        ArrayList<Integer> lastbus = new ArrayList<>();
        if (line.peek() > bus[bus.length - 1] || line.size() < m || line.isEmpty()) {
            tempanswer = bus[bus.length - 1];
        } else {
            for (int k = 0; k < bus.length - 1; k++) {
                takebus(m, k, 0);
            }
            for (int k = 0; k < m; k++) {
                if (!line.isEmpty()) {
                    time = line.peek();
                    if (time <= bus[bus.length-1] && count < m) {
                        lastbus.add(line.poll());
                    }
                } else break;
            }


            if (lastbus.size() < m)
                tempanswer = bus[bus.length - 1];
            else
                tempanswer = lastbus.get(m - 1) - 1;}

            String hour = Integer.toString(tempanswer / 60);
            String min = Integer.toString(tempanswer % 60);
            while (hour.length() < 2) {
                hour = "0" + hour;
            }
            while (min.length() < 2) {
                min = "0" + min;
            }
            answer = hour + ":" + min;
            return answer;
        }


   

    public static void takebus(int m, int i, int count){
        if(!line.isEmpty()) time = line.peek();
        if(time<=bus[i]&&count<m){
            line.poll();
            takebus(m,i,count+1);
        }
        else return;

    }
}
