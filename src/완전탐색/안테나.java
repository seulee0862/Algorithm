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

/**
 *  풀이
 *
 *
 */
public class 안테나 {

    static int n, answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int player1 = Integer.parseInt(st.nextToken());
        int player2 = Integer.parseInt(st.nextToken());

        //경기시작
        playStart(1, player1, player2);

        System.out.println(answer);

    }

    /**
     *
     * 16 8 9
     * 8 4 5
     * 4 2 3
     * 2 1 2
     *
     * 16 10 14
     * 8 5 7
     * 2 3
     *
     * 17 7 17
     * 9 4 9
     * 5 2 5
     * 3 1 3
     * 2 1 2
     */
    static void playStart(int round, int player1, int player2) {


        //둘이만나면
        if (player1 % 2 == 1 && player2 % 2 == 0
            && player1 - player2 == -1) {
            answer = round;
        }
        else {

            //짝수 경기인 경우
            if (round % 2 ==0 ){
                player1 = player1/2 + player1%2;
                player2 = player2/2 + player2%2;
                round = round/2;

                playStart(round, player1, player2);
            }
            else {
                //홀수 경기인 경우
                player1 = player1/2 + player1%2;
                player2 = player2/2 + player2%2;
                round = round/2 + round%2;

                playStart(round, player1, player2);
            }

        }
    }
}
