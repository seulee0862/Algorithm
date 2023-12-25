package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[]    dp = new int[10000001];

    public static void main(String[] args) throws IOException {


        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= N; i++) {

            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            //System.out.println("dp[i] = " + dp[i] + "  i = " + i);
        }

        System.out.println(dp[N]);
    }
}