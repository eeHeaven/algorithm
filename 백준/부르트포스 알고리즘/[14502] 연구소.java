import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static final int empty = 0;
    static final int wall = 1;
    static final int virus = 2;
    static final int tempvirus = 3;
    static int count = 0;
    static int max = Integer.MIN_VALUE;
    static int[][] area;
    static boolean[][] areab;

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        String[] nm = input.split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        area = new int[N][M];
        areab = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String inputline = br.readLine();
            String[] eachLine = inputline.split(" ");
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(eachLine[j]);
                area[i][j] = temp;
            }
        }
        wallSet(0, 0, 3, 3);
        System.out.println(max);
    }

    public static void spreadVirus(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) return;
        if(areab[x][y] == true) return;
        if (area[x][y] == virus || area[x][y] == empty) {
            if (area[x][y] == empty) area[x][y] = tempvirus;
            areab[x][y] = true; // 무한루프 방지용, true로 visit check
            spreadVirus(x - 1, y);
            spreadVirus(x, y - 1);
            spreadVirus(x + 1, y);
            spreadVirus(x, y + 1);
        }
    }

    public static void wallSet(int x, int y, int n, int r) {
        if (r == 0) {
            count = 0;
            // 바이러스 구해서 배열에 넣기, wall boolean 에서 true로 설정
            ArrayList<Location> viruses = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (area[i][j] == virus) {
                        viruses.add(new Location(i, j));
                    }
                    else if(area[i][j] == wall){
                        areab[i][j] = true;
                    }
                }
            }
            //바이러스 퍼트리기
            for (Location l : viruses) {
                spreadVirus(l.x, l.y);
            }
            // 안전구역 count, tempvirus 치우기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    areab[i][j] = false;
                    if (area[i][j] == empty) count++;
                    else if (area[i][j] == tempvirus) area[i][j] = empty;
                }
            }
            //max count 구하기
            max = Math.max(max, count);
            return;
        }
        for (int i = x; i < N; i++) {
            if (i == x) {
                for (int j = y; j < M; j++) {
                    if (area[i][j] == empty) {
                        area[i][j] = wall;
                        wallSet(i, y=j + 1, n, r - 1);
                        area[i][j] = empty;
                    }
                }
            } else for (int j = 0; j < M; j++) {
                if (area[i][j] == empty) {
                    area[i][j] = wall;
                    wallSet(i, y=j + 1, n, r - 1);
                    area[i][j] = empty;
                }
            }
        }
    }

static class Location{
    int x;
    int y;
    public Location(int x, int y){
        this.x = x;
        this.y= y;
    }
}}
