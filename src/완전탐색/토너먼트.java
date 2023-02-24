package 완전탐색;

/**
 *  임한수 vs 김지민
 *
 *  입력값 참가자수 , 김지민, 임한수
 *
 *  출력값
 *
 *  김지민과 임한수가 대결하는 라운드
 *
 *  조건
 *
 *  홀수일경우 마지막번호 부전승,
 *  라운드 시작시 번호재할당
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 토너먼트 {

    static int n, answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int player1 = Integer.parseInt(st.nextToken());
        int player2 = Integer.parseInt(st.nextToken());


        while (player1 != player2) {

            player1 = player1/2 + player1%2;
            player2 = player2/2 + player2%2;
            answer++;
        }
        System.out.println(answer);
    }
}
