package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[] dp = new int[1001];

	public static void main(String[] args) throws IOException {

		int N = Integer.parseInt(br.readLine());

		dp[1] =  1;
		dp[2] =  2;
		dp[3] =  3;

		for (int i=4; i<= N; i++) {
			dp[i] = Math.min(dp[i-1],dp[i-3] ) +1;
		}

		if (dp[N] % 2 == 0) {
			System.out.println("CY");
		}
		else {
			System.out.println("SK");
		}
	}
}
