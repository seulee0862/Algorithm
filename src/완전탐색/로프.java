package 완전탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  입력
 *  3~8개의 정수(-100이상 100이하)배열
 *
 *  최대
 *  정수배열로
 *
 * ( n - n+1) + (n+1 - n+2 ) 형태 마음대로 바꿔서 최대값 출력
 */

/**
 *  그리디 탐색법을 사용할때 정렬이 돼있어야 하는점 다시 상기..
 *  Arrays.sort보다 내가직접 구현한 mergeSort가 더 느린데 이는 재귀함수호출이나 메모리 사용량에
 *  따른 성능저하가 일어나기 때문임
 */

public class 로프 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}
