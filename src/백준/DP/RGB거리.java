package 백준.DP;

import java.io.*;
import java.util.StringTokenizer;

public class RGB거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int r = 0;
        int g = 0;
        int b = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int tempR = r;
            int tempG = g;
            int tempB = b;

            int r1 = Integer.parseInt(st.nextToken());
            int g1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());

            r = Math.min(r1 + tempB, r1+ tempG);
            g = Math.min(g1 + tempR, g1+ tempB);
            b = Math.min(b1 + tempR, b1 + tempG);

        }

        int minValue = Integer.MAX_VALUE;
        minValue = Math.min(minValue, r);
        minValue = Math.min(minValue, g);
        minValue = Math.min(minValue, b);

        System.out.println(minValue);
    }
}
