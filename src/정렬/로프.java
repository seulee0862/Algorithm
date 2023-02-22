package 정렬;

import java.io.*;

/**
 *  입력값
 *
 *  1 ~ 100,000 사이의 N개수
 *  N 번만큼 로프가 버틸 수 있는 중량 입력
 *
 *  출력값
 *  밧줄을 x개이상 사용해서 만들어냈을때
 *  들수있는 최고 증량
 *
 *  15 10 은 하나만 사용하면 15밖에못들지만
 *  15, 10을합치면 각각에 w/x개만큼 부하가 가해져서 최고 20까지 가능
 */
public class 로프 {

    static int[] sorted;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];
        sorted = new int[n];

        for (int i=0; i<n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        mergerSort(rope, 0, rope.length-1);

        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            max = Math.max(max, rope[i] * (n-i));
        }

        bw.write(String.valueOf(max));
        bw.close();
    }

    static void mergerSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergerSort(arr, left, middle);
            mergerSort(arr, middle+1, right);

            merge(arr, left, middle, right);
        }
    }

    static void merge(int[] arr, int left, int middle, int right) {

        int l = left;
        int r = middle + 1;
        int k = left;

        while ( (l <= middle && r <= right)) {
            if (arr[l] < arr[r]) {
                sorted[k++] = arr[l++];
            }
            else {
                sorted[k++] = arr[r++];
            }
        }

        while (l <= middle) {
            sorted[k++] = arr[l++];
        }
        while (r <= right) {
            sorted[k++] = arr[r++];
        }

        for (int i=0; i<=right; i++) {
            arr[i] = sorted[i];
        }
    }
}
