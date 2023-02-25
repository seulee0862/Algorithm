package 수학;

/**
 *  5, 3 를 담을 수 있는 봉지를 통해서
 *
 *  N을 담아가는데 봉지를 최소한으로 쓰는경우 출력 없으면 -1
 */

/**
 *  DP로 구현은 성공했는데 시간초과로 불가능했고
 *  풀이공식을 만들고 푸는 문제
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        /**
         *
         * 1번
         * n%5가 0이라면 n/5 + count 리턴
         * 아니라면
         * mock = n/5;
         * n = n%5 이후에
         * n%3가 0이라면 n/3 + mock + count 리턴
         *
         * 아니라면
         *
         * n >= 3 이라면
         * n-3 한후에 count증가
         * 1번반복
         *
         * n < 3이라면 -1리턴
         */

        int count = 0;
        int mock = 0;
        int remain = 0;
        int answer = -1;

        while (n >= 3) {

           if (n%5 == 0) {
               answer = n/5 + count;
               break;
           }
           else {
               mock = n/5;
               remain = n%5;
               if (remain%3 == 0) {
                   answer = mock + remain/3 + count;
                   break;
               }
               else {
                   n = n-3;
                   count++;
               }
           }
        }

        System.out.println(answer);
    }

}
