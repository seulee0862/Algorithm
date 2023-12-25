package 백준.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 병합정렬 {

    static int[] arr, sorted;
    static int n, m, count, answer = -1;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        sorted = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, arr.length-1);

        System.out.println(answer);
    }

    static void mergeSort(int left ,int right ) {

        if (left < right ) {

            int middle = left + (right-left)/2;

            mergeSort(left, middle);
            mergeSort(middle+1, right);

            merge(left, middle, right);
        }
    }

    static void merge (int left, int middle, int right) {

        int l = left;
        int r = middle + 1;
        int k = left;

        while (l <= middle && r <= right) {

            if (arr[l] < arr[r]) sorted[k++] = arr[l++];
            else sorted[k++] = arr[r++];
        }

        while (l <= middle) sorted[k++] = arr[l++];
        while (r <= right) sorted[k++] = arr[r++];

        for (int i=left; i<= right; i++) {
            count++;
            if (count == m) answer = sorted[i];
            arr[i] = sorted[i];
        }

    }
}
