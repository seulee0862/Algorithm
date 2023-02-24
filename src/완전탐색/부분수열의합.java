package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  입력값
 *
 *  N - 수열수 , S - 정수
 *  조합해서 S가되는 경우의수 출력
 */
public class 부분수열의합 {

    static int n, m, answer = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        if ( m == 0) System.out.println(answer-1);
        else System.out.println(answer);
    }

    static void DFS (int L, int sum) {

        if (L == n) {
            if (sum == m) answer++;
            return;
        }
        else {
            DFS(L+1, sum + arr[L]);
            DFS(L+1, sum);
        }
    }

}
