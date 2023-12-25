package 백준.완전탐색;

import java.io.*;

/**
 *
 *  https://www.acmicpc.net/problem/1065
 *
 *  등차수열의 n번째항은 초항(a1)+ (n-1)두항의차d로 나타낼 수 있따. aN = a1 + (n-1)d
 *
 *  1~9는 그 자체가 수열이고
 *  10~99는 등차가 1개이므로 어떤경우라도 등차수열로 만들어낼 수 있다.
 *
 *  각자리수 끼리 등차수열인수 -> 한수라고 가정했을경우
 *  100이하의 한수는 100개다
 *
 *  여기까지 이해하고 100부터 한수가있는지 완전탐색을 해보자
 */

/**
 *  조건이 1000보다 작지 않고 더 큰수까지 가능했으면
 *  등차를 구하는 공식이 조금 까다로웠을 것 같다.
 */
public class 한수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(solution(n)));
        bw.flush();
        bw.close();

    }

    public static int solution(int n) {

        int answer = 99;
        if (n < 100) return n;
        else {
            for (int i=111; i<=n; i++) {
                int hun = i/100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if (hun - ten == ten - one) answer++;
            }
        }

        return answer;
    }
}