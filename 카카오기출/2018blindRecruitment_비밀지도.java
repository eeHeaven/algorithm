class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];



        for(int i = 0; i<n;i++){
            StringBuilder sb = new StringBuilder();
            String a1 = toReverseBinary(arr1[i],n);
            String a2 = toReverseBinary(arr2[i],n);
            for(int j = n-1; j>=0;j--){
                char c1 = a1.charAt(j);
                char c2 = a2.charAt(j);
                if(c1=='0'&&c2=='0'){
                    sb.append(" ");
                }
                else sb.append("#");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    public static String toReverseBinary(int n,int length){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%2);
            n = n/2;
        }
        while(sb.length()<length){
            sb.append(0);
        }
        String s = sb.toString();
        return s;
    }
}
