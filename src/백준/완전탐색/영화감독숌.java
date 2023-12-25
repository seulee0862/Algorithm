package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  입력값 N
 *
 *  출력값
 *  666이라는 숫자가 포함되며 N 번째로 작은수
 *
 */
public class 영화감독숌 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = -1;

        for (int i=0; i<n; i++) {
            answer = increaseingNum(answer+1);
        }

        System.out.println(answer);
    }

    static int increaseingNum(int x) {

        while (true) {
            if (isEndNum(x)) break;
            x++;
        }
        return x;
    }

    static boolean isEndNum(int x) {

        int count = 0;
        while (x != 0) {

            if (x%10 == 6) count++;
            else count = 0;

            x = x/10;
            if (count == 3) return true;
        }

        return false;
    }
}
