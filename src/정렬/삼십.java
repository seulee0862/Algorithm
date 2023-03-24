package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 삼십 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        //N을 char[] 로 입력받는다
        char[] charArr = br.readLine().toCharArray();
        //오름차순 정렬을 한다
        Arrays.sort(charArr);
        /**
         * 3의 배수에는 1가지 특징이 있다.
         * 3, 6, .. 18, .. 24.. 42 .. 99
         * 모든 자리수의 합이 3의 배수라는 것이다
         * 이걸 이용해서 30의 배수를 구하려고 하면
         *
         * 카드를 섞을 필요도 없이 30의 배수가 가능하다면 -> 최대갑을 구해낼 수있다.
         */

        //char배열의 모든 값을 더해 total에 초기화해준다
        int total = 0;
        for (int i = 0; i < charArr.length; i++) {
            total += charArr[i] - 48;
        }
        //만약 0번째 index가 0이아니거나 total을 3으로나눈 나머지가 0이아니면 실패
        if (charArr[0] != '0' || total%3 != 0) {
            sb.append("-1");
        }
        //맞다면 숫자를 반대로 뒤집어서 출력하면 최대값
        else {
            for (int i = charArr.length-1; i >=0; i--) {
                sb.append(charArr[i]);
            }
        }

        System.out.println(sb.toString());

    }
}
