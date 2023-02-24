package 정렬;

/**
 *  입력값
 *
 *  N 집의수
 *  N개의 집의위치
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  정렬후 시작점, 끝지점까지 반복하면서 안테나를놓고 최소값 출력
 */
public class Main {

    static int n, answer;
    static int dis = Integer.MAX_VALUE;
    static int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
    static int[] homeArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        homeArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            start = Math.min(start, x);
            end = Math.max(end, x);
            homeArr[i] = x;
        }
        Arrays.sort(homeArr);

        if (n % 2 == 0){
            answer = homeArr[ n/2 -1 ];
        } else {
            answer = homeArr[ n/2];
        }

        System.out.println(answer);

    }
}
