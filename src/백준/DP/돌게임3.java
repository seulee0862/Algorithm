package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임3 {

    static BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
    static boolean          dp[] = new boolean[1001];
    static int              N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        dp[1] = true;
        dp[3] = true;
        dp[4] = true;
        for (int i = 5; i <= N; i++) {
            if (dp[i - 1] && dp[i - 3] && dp[i -4]) {
                dp[i] = false;
            }
            else {
                dp[i] = true;
            }
        }

        answerPrint();

        for (int i = 0; i < N; i++) {
            System.out.println(i+ " : " + dp[i]);
        }
    }

    private static void answerPrint() {
        if (dp[N]) {
            System.out.println("SK");
        }
        else {
            System.out.println("CY");
        }
    }
}