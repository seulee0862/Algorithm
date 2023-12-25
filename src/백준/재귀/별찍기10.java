package 백준.재귀;

import java.io.*;
import java.util.Arrays;

public class 별찍기10 {

    static String[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        board = new String[n][n];

        Arrays.stream(board).forEach(row -> Arrays.fill(row, "*"));
        makePattern(n);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {

                bw.write(board[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();


    }

    static void makePattern(int n) {

        if (n == 3) {
            drawPattern(n);
            return;
        }
        else {
            drawPattern(n);
            makePattern(n/3);
        }
    }

    /**
     *
     *  3 3행렬은 행열이 2이상 2이하이면 지움
     *  9 9 행렬은 행렬이 4이상 6이하이면 지움
     *  27 27 행렬은 10 초과 18이하이면 지움
     *
     *  n/3 + 1부터 n/3 + + n/3 까지 지우면 된다
     *
     */
    static void drawPattern(int n) {

        // index는 0 부터시작하니까 1감소
        int startIndex = n/3;
        int endIndex = n/3 + n/3 -1;

        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board.length; j++) {
                if (i%n >= startIndex && i%n <= endIndex
                    && j%n >= startIndex && j%n <= endIndex) {
                    board[i][j] = " ";
                }
            }
        }
    }
}
