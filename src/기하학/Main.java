package 기하학;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /**
     *
     *  1. 사다리꼴 // 땡
     *  2. 평행사변형
     *  3. 마름모
     *  4. 직사각형, 정사각형
     *
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1,y1, x2,y2, x3,y3; //좌표

        // 점 A, B, C입력
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());




        if ((x2-x1)*(y3-y2) == (x3-x2)*(y2-y1)) {
            bw.write("-1");
        }
        else {
            double d1 = getDistance(x1, y1, x2, y2);
            double d2 = getDistance(x1, y1, x3, y3);
            double d3 = getDistance(x2, y2, x3, y3);
            double max = Math.max(d1 + d2, Math.max(d1 + d3, d2 + d3));
            double min = Math.min(d1 + d2, Math.min(d1 + d3, d2 + d3));

            bw.write((max - min) * 2 + "");
        }

        bw.close();

    }

    static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1 - y2, 2));
    }
}
