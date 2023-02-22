package 완전탐색;

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
public class Main22 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int wBox = 0;
        int bBox = 0;
        boolean wCheck = true;
        boolean bCheck = true;

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(),"");
            for (int j=0; j<n; j++) {
                if (st.nextToken().equals('W')) {
                    if (bCheck) bBox++;
                }
                else {
                    if (wCheck) wBox++;
                }
                wCheck = !wCheck;
                bCheck = !bCheck;
            }
        }

        System.out.println(Math.max(wBox, bBox));
    }
}
