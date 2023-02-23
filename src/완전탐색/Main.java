package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  입력
 *
 *  문자열
 *  찾을문자
 *
 *  출력
 *  겹치는 구간없이 찾을문자가 몇번 나오는지 출력
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str1 = br.readLine();
        String str2 = br.readLine();
        int str2Len = str2.length();

        int pt = 0;
        int count = 0;
        int answer = 0;
        for (int i=0; i<str1.length(); i++) {

            if (str1.charAt(i) == str2.charAt(pt % str2Len)) {
                count++;
                pt++;
            }
            else {
                count = 0;
            }

            if (count == str2Len) {
                answer++;
                count = 0;
            }
        }

        System.out.println(answer);
    }
}
