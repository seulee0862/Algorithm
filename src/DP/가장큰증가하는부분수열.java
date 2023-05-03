package DP;

import java.io.*;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] hap = new int[N];
        int[] dp  = new int[N];
        int answer = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
            hap[i] = value;
            dp[i] = value;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], hap[i] + dp[j]);
                }
            }
            //System.out.println("dp[i] = " + dp[i]);
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
