package 백준.DP;

import java.io.*;
import java.util.StringTokenizer;

public class 정수a를k로만들기 {

    static BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer  st;
    static int              N, K;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int count = 0;



        while (N != K) {
            int rest = K % 2;
            count += rest;
            K = K - rest;

            if (K == N) {
                break;
            }
            if (K < 2*N) {
                K = K - 1;
                count++;
                continue;
            }

            K = K/2;
            count++;

        }

        System.out.println(count);
    }

    /**

     *          7 77
     *
     *
     *
     */
}
