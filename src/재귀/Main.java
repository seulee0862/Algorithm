package 재귀;

import java.io.*;
import java.util.Arrays;

public class Main {

    /**
     *
     *  1일때 1
     *
     *  2일때
     *  5x5
     *  2, 4번째줄에 양끝지점을 제외한 공백처리
     *
     *
     *  3일떄
     *  9x9
     *  2, 8번째줄에 양끝지점을 제외한 공백처리
     *
     *  n입력 받으면
     *  양끝지점 을제외한 n+1, n-1공백처리
     *  n은 4씩증가
     */

    static String[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = ((Integer.parseInt(br.readLine()) - 1) * 4) + 1;

        board = new String[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], "*");
        }

        draw(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }

        bw.close();
    }

    static int row = 1;
    static int col = 1;

    static void draw(int n) {

        if (n == 1) return;
        else {
            removeStar(n);
            row += 1;
            col += 2;
            draw(n-4);
        }
    }

    static void removeStar(int n) {

        for (int i = 0; i < board.length; i++) {
            for (int j = row; j < board.length - row; j++) {

                if (i == col || i+1 == board.length - col) {
                    board[i][j] = " ";
                }
            }
        }
    }
}
