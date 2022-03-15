import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 문제 한줄씩 읽어오는 방법은 String XX = br.readLine() 하면 됨
//출력은 그냥 sout
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int s;
    static Queue<Emoticon> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        String first = br.readLine();
        s = Integer.parseInt(first);

        q.add(new Emoticon(1, 0, 0));

        boolean[][] visited = new boolean[2001][1001];

        while (!q.isEmpty()) {
            Emoticon e = q.poll();
            int screen = e.screen;
            int clipboard = e.clipboard;
            int time = e.time;
            if (screen == s) {
                System.out.println(time);
                return;
            }
            if (screen - 1 >= 2 && visited[screen - 1][clipboard] == false) { // 스크린에서 한개의 이모티콘 빼기
                visited[screen - 1][clipboard] = true;
                q.add(new Emoticon(screen - 1, clipboard, time + 1));
            }
            if (screen < 1000 && clipboard != screen) { // 스크린에 있는 이모티콘 클립보드에 복사하기
                q.add(new Emoticon(screen, screen, time + 1));
            }
            if (clipboard > 0 && screen + clipboard < 2000) {
                if (visited[screen + clipboard][clipboard] == false) {
                    visited[screen + clipboard][clipboard] = true;
                    q.add(new Emoticon(screen + clipboard, clipboard, time + 1));
                }
            }
        }

    }
}

class Emoticon{
    public int screen;
    public int clipboard;
    public int time;

    public Emoticon(int screen, int clipboard, int time) {
        this.screen = screen;
        this.clipboard = clipboard;
        this.time = time;
    }
}
