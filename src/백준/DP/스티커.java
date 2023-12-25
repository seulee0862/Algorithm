package 백준.DP;

import java.io.*;
import java.util.StringTokenizer;

public class 스티커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N - 1; i++) {
                int a = arr[0][i];
                int b = arr[1][i] + arr[0][i + 1];
                int c = arr[0][i] + arr[1][i + 1];
                int d = arr[1][i];
                arr[0][i+1] = Math.max(a, b);
                arr[1][i+1] = Math.max(c, d);
            }

            int maxValue = Math.max(arr[0][N-1], arr[1][N-1]);
            bw.write(maxValue + "\n");
        }

        bw.close();
    }
}
