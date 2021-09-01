import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String,String> hm = new HashMap<>();
        ArrayList<Memberlog> logs= new ArrayList<>();

        for(int i = 0; i<record.length;i++){
            String[] inputs = record[i].split(" ");
            switch(inputs[0]){
                case"Enter":
                    logs.add(new Memberlog(inputs[1],inputs[0]));
                    hm.put(inputs[1],inputs[2]);
                    break;
                case"Change":
                    hm.put(inputs[1],inputs[2]);
                    break;
                case"Leave":
                    logs.add(new Memberlog(inputs[1],inputs[0]));
                    break;
            }
        }
        String[] answer = new String[logs.size()];
        for(int i = 0; i<logs.size();i++){
            Memberlog m = logs.get(i);
            String nickname = hm.get(m.getUid());
            switch(m.getOrder()){
                case"Enter":
                    answer[i] = nickname+"님이 들어왔습니다.";
                    break;
                case"Leave":
                    answer[i] = nickname+"님이 나갔습니다.";
                    break;
            }
        }
        return answer;
    }
}

class Memberlog{
    private String uid;
    private String order;

    public Memberlog(String uid, String order) {
        this.uid = uid;
        this.order = order;
    }

    public String getUid() {
        return uid;
    }

    public String getOrder() {
        return order;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
