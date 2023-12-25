package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  입력값
 *  짝수의 N
 *  N^2 백준.완전탐색.행렬
 *
 *  출력값
 *  행렬에 값을 통해서 팀구성시 두팀의 능력치차이가 가장 작은경우를 출력
 */
public class 스타트와링크 {

    static int[][] board;
    static boolean[] ch;
    static int n;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new boolean[n];
        board = new int[n][n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);

        System.out.println(answer);


    }

    static void DFS(int index, int L) {

        if (answer == 0) return;
        if (L == n/2) {
            diff();
        }
        else {
            for (int i=index; i<n; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    DFS(i+1, L + 1);
                    ch[i] = false;
                }
            }
        }

    }

    static void diff() {

        int teamRed = 0;
        int teamBlue = 0;

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {

                if (ch[i] == true && ch[j] == true) {
                    teamRed += board[i][j];
                    teamRed += board[j][i];
                }
                else if (ch[i] == false && ch[j] == false) {
                    teamBlue += board[i][j];
                    teamBlue += board[j][i];
                }
            }
        }

        answer = Math.min(answer, Math.abs(teamRed - teamBlue));
    }
}
