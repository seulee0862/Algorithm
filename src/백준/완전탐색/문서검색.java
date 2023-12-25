package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  입력
 *
 *  문자열
 *  찾을문자
 *
 *  출력
 *  겹치는 구간없이 찾을문자가 몇번 나오는지 출력
 */
public class 문서검색 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        int len = str2.length();

        int count = 0;
        /**
         * subString의 뒤에부분이 해당인덱스 미만이라 for문의 길이까지 순회해야 전부 검색했었음
         */
        for (int i=0; i<=str1.length()-len; i++) {
            if (str2.equals(str1.substring(i, i+len))) {
                count++;
                i += len-1;
            }
        }

        System.out.println(count);
    }
}
