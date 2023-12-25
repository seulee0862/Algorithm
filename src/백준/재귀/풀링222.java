package 백준.재귀;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 풀링222 {

    static BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter   bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer  st;

    static int[][]  board;
    static int[]    tmp;
    static int[]    pooling = new int[4];

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        tmp = new int[N * N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(N);

        bw.close();
    }

    static void solution(int currentSize) throws IOException {

        if (currentSize == 1) {
            bw.write(board[0][0]+"");
            return;
        }

        int idx = 0;
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < currentSize; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    pooling[0] = board[i][j];
                    pooling[1] = board[i][j+1];
                    pooling[2] = board[i+1][j];
                    pooling[3] = board[i+1][j+1];

                    Arrays.sort(pooling);

                    tmp[idx++] = pooling[2];
                }
            }
        }

        idx = 0;
        int newSize = currentSize/2;
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                board[i][j] = tmp[idx++];
            }
        }

        solution(newSize);
    }

}
