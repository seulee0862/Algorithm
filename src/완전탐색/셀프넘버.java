package 완전탐색;

/**
 *
 *  https://www.acmicpc.net/problem/4673
 *
 *  d(n) 이라는 공식은 -> d(123) == 123+1+2+3 이다 n + 각자리수
 *  이때 129의 생성자는 123이다. 즉, d(n)을통해서 m이라는 값을 만들 수 있다면 n은 m의생성자
 *  생성자가 존재하지 않는수를 셀프넘버라고 할때 (양의정수만 취급 0 포함하지 않음)
 *
 *  입력 x
 *
 *  출력
 *  10000보다 같거나 작은 셀프넘버를 전부 출력
 */

import java.io.*;
import java.util.StringTokenizer;

/**
 *  * d(n)함수를 구현해서 1부터 10000까지 사용해보자
 */
public class 셀프넘버 {

    static int[] ch = new int[10001];

    public static void main(String[] args) throws IOException {
        셀프넘버 main = new 셀프넘버();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = "";
        int temp = 0;
        for (int i=1; i<=10000; i++) {
            str = Integer.toString(i);
            temp = i;
            for (int j=0; j<str.length(); j++) {
                temp += str.charAt(j)-48;
            }
            if (temp <= 10000) ch[temp] = 1;
            else continue;
        }

        for (int i=1; i<=10000; i++) {
            if (ch[i] == 0) bw.write(String.valueOf(i) + "\n");
        }
        bw.close();
    }
}

/**
 * for (int i = 0; i < 10; i++) {
 *             for (int j = 0; j < 10; j++) {
 *                 for (int m = 0; m < 10; m++) {
 *                     for (int n = 0; n < 10; n++) {
 *                         if (1001 * i + 101 * j + 11 * m + 2 * n < 10001) {
 *                             ch[1001 * i + 101 * j + 11 * m + 2 * n]++;//1000*i는 그단위값만 구함, 1001*i는 그단위값 + 그단위자리수값 구함함                        }
 *                         }
 *                     }
 *                 }
 *             }
 *
 *         }
 *
 *         for (int i = 1; i < 10000; i++) {
 *             if (ch[i] == 0) bw.write(i + "\n");
 *         }
 */