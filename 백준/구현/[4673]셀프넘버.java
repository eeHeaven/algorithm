class Main {
     static boolean[] answer = new boolean[10001]; // 셀프넘버가 아니면 true
    public static void main(String[] args) {
        answer[0] = true;
        for(int i = 1; i<10000;i++){
            d(i);
        }
        for(int i = 1; i<=10000;i++){
            if(answer[i] == false) System.out.println(i);
        }
    }
    public static void d(int n){
        if(n>10000) return;
        int length = (int)(Math.log10(n)+1); // key 값의 자릿수
        if(length == 1){
            d(n+n);
            if((n+n)<=10000) answer[n+n] = true;
        }
        else if(length ==2){
            d(n+n/10+n%10);
            if((n+n/10+n%10)<=10000) answer[n+n/10+n%10] = true;
        }
        else if(length ==3){
            d(n+n/100+(n%100)/10+n%10);
            if((n+n/100+(n%100)/10+n%10)<=10000) answer[n+n/100+(n%100)/10+n%10] = true;
        }
        else {
            d(n+n/1000+(n%1000)/100+(n%100)/10+n%10);
            if((n+n/1000+(n%1000)/100+(n%100)/10+n%10)<=10000) answer[n+n/1000+(n%1000)/100+(n%100)/10+n%10] = true;}
    }
}
