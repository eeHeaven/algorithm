import java.util.HashMap;

class Solution {
    public static HashMap<String,String> relationship;
    public static  HashMap<String, Integer> profits;
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
         relationship = new HashMap<>();
         profits = new HashMap<>();

        for(int i = 0; i< enroll.length;i++){
            relationship.put(enroll[i],referral[i]);
        }
        for(int i = 0; i< seller.length;i++){
            distribute(seller[i],amount[i]*100);
        }
        int index = 0;
        for(String member: enroll){
            if(profits.containsKey(member)) answer[index] = profits.get(member);
            else answer[index] = 0;
            index++;
        }

        return answer;
    }

    public static void distribute(String seller, int price){
        String recommander = relationship.get(seller);
        if((price*0.1)<1){
            profits.put(seller, profits.getOrDefault(seller,0)+price);
        }
        else if(recommander.equals("-")){
            profits.put(seller, profits.getOrDefault(seller,0)+(int)(price - (int)(price*0.1)));
        }
        else {
            profits.put(seller, profits.getOrDefault(seller,0)+(int)(price - (int)(price*0.1)));
            distribute(recommander,(int)(price*0.1));
        }
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(solution(enroll,referral,seller,amount));
    }
}
