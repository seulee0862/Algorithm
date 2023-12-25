package 백준.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 쿼드트리 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - 48;
            }
        }

        quadDivision(0, 0, n);

        bw.close();


    }

    static void quadDivision(int x, int y, int size) throws IOException {

        if (isPossible(x, y, size)) {
            bw.write(String.valueOf(board[x][y]));
            return;
        }

        int divisionSize = size/2;

        bw.write("(");
        quadDivision(x, y, divisionSize);
        quadDivision(x, y+divisionSize, divisionSize);
        quadDivision(x+divisionSize, y, divisionSize);
        quadDivision(x+divisionSize, y+divisionSize, divisionSize);
        bw.write(")");
    }

    public static boolean isPossible(int x, int y, int size) {

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (board[x][y] != board[i][j]) {
                    return false;
                }

            }
        }

        return true;
    }
}
