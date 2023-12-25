package 백준.기하학;

import java.io.*;
import java.util.StringTokenizer;

public class 하키 {

    static int width, height, x, y, x1, y1, r;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x1 = x+width;
        y1 = y+height;
        r = height/2;

        int count = 0;
        int p = Integer.parseInt(st.nextToken());
        Player[] players = new Player[p];
        for (int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            if ( inPitch(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) ) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean inPitch(int playerX, int playerY) {

        if (playerX >= x && playerX <= x1
            && playerY >= y && playerY <= y1) {
            return true;
        }

        double dis1 = Math.pow(playerX-x, 2) + Math.pow(playerY-(y+r), 2);
        double dis2 = Math.pow(playerX-x1, 2) + Math.pow(playerY-(y+r), 2);
        double powR = Math.pow(r, 2);

        if (dis1 <= powR || dis2 <= powR) {
            return true;
        }

        return false;
    }

    static class Player {

        int x;
        int y;

        public Player(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
