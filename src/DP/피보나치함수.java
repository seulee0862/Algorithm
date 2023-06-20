package DP;

import java.io.*;

public class 피보나치함수 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        int N;
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            int zero = dp[i-1][0] + dp[i-2][0];
            int one = dp[i-1][1] + dp[i-2][1];
            dp[i][0] = zero;
            dp[i][1] = one;
        }

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int zero = dp[N][0];
            int one = dp[N][1];
            bw.write(zero + " " + one);
            bw.newLine();
        }

        bw.close();
    }
}