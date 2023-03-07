package DP;

import java.io.*;
import java.util.StringTokenizer;

public class 다리놓기 {

    static int[][] ch = new int[30][30];

    /**
     *
     * n+1 C r+1 = n C r + n C r+1
     *
     * n C 0 = n C n = 1
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(combi(b, a)+"\n");
        }

        bw.close();
    }

    static int combi(int a, int b) throws IOException{

        if (ch[a][b] > 0) {
            return ch[a][b];
        }

        if (a == b || b == 0) {
            return ch[a][b] = 1;
        }

        return ch[a][b] = combi(a-1, b-1) + combi(a-1 ,b);
    }
}
