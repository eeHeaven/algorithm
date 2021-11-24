import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
    String n = br.readLine();
    int numberN = Integer.parseInt(n);
    String nArray = br.readLine();
    String[] arrN = nArray.split(" ");
    int[] Narr = new int[arrN.length];
   for(int i = 0; i<arrN.length;i++){
       Narr[i] = Integer.parseInt(arrN[i]);
   }

            String m = br.readLine();
            int numberM = Integer.parseInt(n);
            String mArray = br.readLine();
            String[] arrM = mArray.split(" ");
            int[] Marr = new int[arrM.length];
            for(int i = 0; i<arrM.length;i++){
                Marr[i] = Integer.parseInt(arrM[i]);
            }

            Arrays.sort(Narr);
            for(int eachM: Marr){
                if(binarySearch(0,Narr.length-1,Narr,eachM)) System.out.println("1");
                else System.out.println("0");
            }
    }

    public static boolean binarySearch(int start, int end, int[] arr,int target){
        while(start<=end){
        int mid = (start+end)/2;
        if(arr[mid] == target) return true;
        if(arr[mid]>target){
            end = mid-1;
        }
        else start = mid+1;

    }
        return false;
}}
