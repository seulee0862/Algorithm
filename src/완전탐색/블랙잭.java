package 완전탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2798
 *
 *  입력값 M - 임의의수 , N - 선택가능한 숫자카드수
 *
 *  출력값 N의카드중 3장을뽑았을때 M을 넘지않으면서 가장 근접할 수있는 합출력
 *
 */
public class 블랙잭 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i< n -2; i++) {
            for (int j = i+1; j< n -1; j++) {
                for (int k = j+1; k< n; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if (sum <= m && sum > answer) answer = sum;
                }
            }
        }
        return answer;
    }
}