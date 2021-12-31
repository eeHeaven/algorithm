import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] s;
    static int teamskill;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        //초기 input값 가져오고 초기 board 상태 설정
        String input = br.readLine();
       n= Integer.parseInt(input);
       s= new int[n][n];
       for(int i = 0; i<n;i++){
           String input2 = br.readLine();
           String[] each = input2.split(" ");
           for(int j = 0; j<n;j++){
               s[i][j] = Integer.parseInt(each[j]);
           }
       }
       teamMake(0,0,new int[n/2]);
        System.out.println(min);
    }
    public static void teamMake(int start, int count,int team[]){
        if(count == n/2){
            int[] otherteam = otherTeam(team);
            int team1 = teamSkill(team);
            int team2 = teamSkill(otherteam);
            int thisvalue = Math.abs(team1 - team2);
            min = Math.min(thisvalue,min);
            return;
        }
        for(int i = start; i<n;i++){
             team[count] = i;
            teamMake(i+1,count+1,team);
            }
        }

    public static int[] otherTeam(int[] team){
        int[] other = new int[n/2];
       ArrayList<Integer> member = new ArrayList<>();
       for(int i = 0; i<n; i++){
           member.add(i);
       }
       for(int m : team){
          member.remove((Integer)m);
       }
       for(int i =0;i<n/2;i++){
           other[i] = member.get(i);
       }
        return other;
    }
    public static int teamSkill(int[] team){
         teamskill = 0;
        teamCombination(0,0,team,new int[2]);
        return teamskill;
    }
    public static void teamCombination(int start, int count, int[] team, int[] teamcombination){
        if(count == 2){
            int m1 = teamcombination[0];
            int m2 = teamcombination[1];
            teamskill += s[m1][m2]+s[m2][m1];
            return;
        }
        for(int i = start; i<n/2; i++){
            teamcombination[count] = team[i];
            teamCombination(i+1,count+1,team,teamcombination);
            }
        }
    }
