import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static ArrayList<Long> num = new ArrayList<>();
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;



    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        n = Integer.parseInt(input);
        String next = br.readLine();
        String[] nums = next.split(" ");
        long thisnum = Long.parseLong(nums[0]);
        num.add(thisnum);
        min = Math.min(min, thisnum);
        max = Math.max(max,thisnum);
        for(int i = 1; i<n;i++){
            long tempnum = Long.parseLong(nums[i]);
            num.add(tempnum);
            min = Math.min(min, tempnum);
            max = Math.max(max,tempnum);
            if(thisnum%tempnum == 0) continue;
            else if(tempnum%thisnum == 0) thisnum = tempnum;
            else{
                long tempmin = Math.min(tempnum,thisnum);
                int tempmax = 1;
                for(int j = 2;j<tempmin;j++){
                    if(thisnum%j ==0 && tempnum%j == 0){
                        tempmax = Math.max(tempmax,j);
                    }
                }
                thisnum = (thisnum/tempmax)*(tempnum/tempmax)*tempmax;

            }
        }
        if(num.contains((Long)thisnum)) System.out.println(min*max);
        else System.out.println(thisnum);

    }
}
