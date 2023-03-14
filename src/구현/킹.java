package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class 킹 {

    static int kingx;
    static int kingy;
    static int stonex;
    static int stoney;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        kingx = king.charAt(0) - 'A'+1;
        kingy = king.charAt(1) - '0';

        String stone = st.nextToken();
        stonex = stone.charAt(0) - 'A'+1;
        stoney = stone.charAt(1) - '0';

        int movenum = Integer.parseInt(st.nextToken());

        int dx = 0, dy = 0;
        for (int i = 0; i < movenum; i++) {
            String mtype = br.readLine();

            if(mtype.equals("T")){
                dx = 0;
                dy = 1;
            }
            if(mtype.equals("RT")) {
                dx = 1;
                dy=1;
            }
            if(mtype.equals("R")) {
                dx = 1;
                dy=0;
            }
            if(mtype.equals("RB")) {
                dx=1;
                dy=-1;
            }
            if(mtype.equals("B")) {
                dx=0;
                dy=-1;
            }
            if(mtype.equals("LB")) {
                dx = -1;
                dy=-1;
            }
            if(mtype.equals("L")) {
                dx = -1;
                dy=0;
            }
            if(mtype.equals("LT")) {
                dx = -1;
                dy=1;
            }
            move(dx, dy);
        }

        char kx = (char) ('A' + kingx-1);
        char ky = (char) ('0' + kingy );
        char sx = (char) ('A' + stonex-1);
        char sy = (char) ('0' + stoney);

        System.out.println(kx + "" +ky + "\n" + sx + "" + sy);
    }

    static boolean check(int i, int j) {
        if (1<=i && i<=8 && 1<=j && j<=8) return true;
        return false;
    }

    static void move (int dx, int dy) {

        int knx = kingx + dx;
        int kny = kingy + dy;

        if (check(knx, kny)) {
            if (knx == stonex && kny == stoney) {
                if (check(stonex+dx, stoney+dy)) {
                    stonex += dx;
                    stoney += dy;
                    kingx = knx;
                    kingy = kny;
                }
            }
            else {
                kingx = knx;
                kingy = kny;
            }
        }
    }
}
