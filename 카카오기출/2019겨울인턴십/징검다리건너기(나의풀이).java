import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

class Solution {
static PriorityQueue<Stone> pq = new PriorityQueue<>();
static int[] prev;
static int[] next;
static int K;
static int stoneNum;
static int answer = 0;
    public static void main(String[] args) {


    }
    public static int solution(int[] stones, int k) {
        prev = new int[stones.length];
        next = new int[stones.length];
        for(int i = 0; i<stones.length;i++){
            prev[i] = i-1;
            next[i] = i+1;
        }
        next[stones.length-1] = -1;
        stoneNum = stones.length;
        K = k;
        for(int i = 0; i<stones.length;i++){
            pq.add(new Stone(stones[i],i));
        }
        while(!pq.isEmpty()){
            Stone thisStone = pq.peek();
            answer = thisStone.value;
            if(!remove(thisStone.index)) return answer;
        }
        return answer;
    }

    public static boolean remove(int n){
        if(next[n]==-1){
            if(stoneNum-prev[n]>K) return false;
        }
        else prev[next[n]] = prev[n];
        if(prev[n]==-1){
            if(next[n]+1>K) return false;
        }
        else next[prev[n]] = next[n];
        if(next[n]-prev[n]>K) return false;
        pq.poll();
        return true;
    }
}
class Stone implements Comparable<Stone>{
    int value;
    int index;

    @Override
    public int compareTo(Stone o) {
        return this.value <= o.value ? -1 : 1;
    }

    public Stone(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
