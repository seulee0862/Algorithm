package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int          N;
    static long[]    pinaryNum;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        }

        pinaryNum = new long[N+1];


        pinaryNum[0] = 0;
        pinaryNum[1] = 1;

        for (int i = 2; i <= N; i++) {
            pinaryNum[i] = pinaryNum[i-2] + pinaryNum[i-1];
        }

        System.out.println(pinaryNum[N]);

    }

//    public static void DFS(int depth, int num) {
//
//        if (depth == N) {
//            count++;
//            return;
//        }
//
//        if (num == 0) {
//            DFS(depth + 1, 0);
//            DFS(depth + 1, 1);
//        }
//        else {
//            DFS(depth + 1, 0);
//        }
//
//    }

    /*
        1*1*2*1

        1 - 1
        0 - 1
        1                   0 - 2
        0                   0                   1 -3
        0           1       0           1       0 - 5
        0   1       0       0   1       0       0   1 -8
        0 1 0       0 1     0 1 0       0 1     0 1 0 - 13
        01 0 01     01 0    01 0 01     01 0    01 0 01 - 21

     */
}
