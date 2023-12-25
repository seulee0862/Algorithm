package 백준.완전탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  입력값
 *  M, N , (M x N 정사각형 배열값 입력)
 *
 *  출력
 *  체스판으로 만들기 위해 색칠한 사각형의 최소 개수
 *
 *  풀이
 *  반복문을 돌면서
 *  1행1열이 흰색일때 검은색일때 경우이 사각형의 개수는 몇개여야하는지 구하고
 *  최소값 리턴
 */

/**
 *
 *  주워진 체스판에서 모든경우의 8x8 체스판 잘라낸후
 *  흰색으로 시작하는 체스판, 검은색으로 시작하는 체스판의 모든 경우의 수 찾는 문제..
 *  백준.완전탐색 문제
 *
 */
public class 체스판다시칠하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[][] arr = new String[m][n];

        for (int i=0; i<m; i++) {
            arr[i] = br.readLine().split("");
        }

        int answer = Integer.MAX_VALUE;
        int x =0;
        int y =0;
        while (x+7 < m) {
            y=0;
            while (y+7 < n) {
                int xIndex = x+8;
                int yIndex = y+8;

                int wBox = 0;
                boolean colorCheck = true;
                for (int i=x; i<xIndex; i++) {
                    for (int j=y; j<yIndex; j++) {
                        if (arr[i][j].equals("B")) {
                            if (colorCheck) wBox++;
                        } else {
                            if (!colorCheck) wBox++;
                        }
                        colorCheck = !colorCheck;
                    }
                    colorCheck = !colorCheck;
                }
                answer = Math.min(answer, wBox);

                int bBox = 0;
                colorCheck = true;
                for (int i=x; i<xIndex; i++) {
                    for (int j=y; j<yIndex; j++) {
                        if (arr[i][j].equals("W")) {
                            if (colorCheck) bBox++;
                        }
                        else {
                            if (!colorCheck) bBox++;
                        }
                        colorCheck = !colorCheck;
                    }
                    colorCheck = !colorCheck;
                }
                answer = Math.min(answer, bBox);
                y++;
            }
            x++;
        }

        System.out.println(answer);
    }
}
