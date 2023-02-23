package 완전탐색;

/**
 *  입력값
 *
 *  N - 인원수
 *  x - 몸무게, y - 키
 *
 *  출력값
 *  각 덩치 등수
 */

import java.io.*;
import java.util.StringTokenizer;

public class 덩치 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] person = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {
            int rank = 1;
            for (int j=0; j<n; j++) {

                if (i == j) continue;
                if (person[i][0] < person[j][0]
                    && person[i][1] < person[j][1]) rank++;
            }
            bw.write(rank+" ");
        }

        bw.close();
    }
}