import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long maxHight =0;
    public static void main(String[] args) throws IOException {
    String first = br.readLine();
    String[] firsts = first.split(" ");
    long treeNum = Integer.parseInt(firsts[0]);
    long M = Integer.parseInt(firsts[1]);
    String second  = br.readLine();
    String[] seconds = second.split(" ");
    long[] treeH = new long[seconds.length];
    long maxnum = 0;
    for(int i  =0; i<seconds.length; i++){
        treeH[i] =Integer.parseInt(seconds[i]);
       maxnum =  Math.max(treeH[i],maxnum);
    }
     System.out.println(binarySearch(0,maxnum,M,treeH));
}

public static long binarySearch(long start, long end, long target,long[] treeH){
        long mid = 0;
        while(start<=end){
            mid = (start+end)/2;
            long result = treeCut(treeH,mid,target);
            if(result<target) end = mid-1;
            else{ if(maxHight<mid) maxHight = mid;
                start = mid+1;
            }
        }
        return maxHight;
}

public static long treeCut(long[] treeH,long H,long target){
        long getM = 0;
        for(long treeHight: treeH){
            if((treeHight - H)>0) getM+=treeHight-H;
        }
        return getM;
}

}
