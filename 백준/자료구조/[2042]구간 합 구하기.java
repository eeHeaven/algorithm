import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] tree;
    public static void main(String[] args) throws IOException {
        int[] inputs = new int[3];
    String[] input =  br.readLine().split(" ");

      for(int i = 0; i<3;i++) inputs[i] = Integer.parseInt(input[i]);

      int n = inputs[0];
      int m = inputs[1];
      int k = inputs[2];

       tree = new long[n*4];
       long[] numbers = new long[n];
      for(int i = 1; i<=n;i++) numbers[i-1] = Long.parseLong(br.readLine());
      build(numbers, 1,0,n-1);
      for(int i = n+1;i<n+m+k+1;i++){
          input =br.readLine().split(" ");
          int a = Integer.parseInt(input[0]);
          int b = Integer.parseInt(input[1]);
          long c = Long.parseLong(input[2]);
          switch(a){
              case 1:
                  update(b-1,c-numbers[b-1],1,0,n-1);
                  numbers[b-1] = c;
                  break;
              case 2:
                  System.out.println(sum(b-1,c-1,1,0,n-1));
                  break;
          }
      }

        }

        public static long merge(long left, long right){
        return left+right;
        }
        public static long build(long[] numbers, int node, int leftnode, int rightnode){
                if(leftnode == rightnode) return tree[node] = numbers[leftnode];

                int mid = leftnode+(rightnode-leftnode)/2;
                long leftval = build(numbers, node*2,leftnode,mid);
                long rightval = build(numbers, node*2+1,mid+1,rightnode);
                return tree[node] = merge(leftval,rightval);
        }

        public static long sum(int left, long right, int node, int leftnode, int rightnode){
                if(left> rightnode || right <leftnode) return 0;
                if(left<=leftnode&& rightnode<=right) return tree[node];

                int mid = leftnode+ (rightnode-leftnode)/2;
                return merge(sum(left,right,node*2,leftnode,mid),sum(left,right,node*2+1,mid+1,rightnode));
        }

        public static void update(int index, long value,int node, int leftnode, int rightnode){
                if(index>rightnode||index<leftnode) return;
                tree[node]+=value;
                if(leftnode!=rightnode){
                    int mid = leftnode +(rightnode-leftnode)/2;
                    update(index,value,node*2,leftnode,mid);
                    update(index,value,node*2+1,mid+1,rightnode);
                }
        }



            }
