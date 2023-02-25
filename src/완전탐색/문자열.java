package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 *
 */
public class 문자열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        int disAB = B.length() - A.length();

        int minValue = Integer.MAX_VALUE;
        int count = 0;
        for (int i=0; i<=disAB; i++) {
            for (int j=0; j<A.length(); j++) {

                if (A.charAt(j) != B.charAt(i + j)) count++;
            }
            minValue = Math.min(minValue, count);
            count = 0;
        }

        System.out.println(minValue);
    }
}
