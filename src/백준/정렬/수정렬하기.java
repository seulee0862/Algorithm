package 백준.정렬;

import java.util.Scanner;

public class 수정렬하기 {

    static int[] tmp;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        tmp = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        mergeSort(arr, 0, arr.length-1);

        for (int x : arr) System.out.println(x);
    }

    static void mergeSort (int[] arr, int left, int right) {

        if (left<right) {
            int middle = (left+right)/2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);

            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {

        int l = left;
        int r = middle+1;
        int k = left;

        while (l <= middle && r <= right) {

            if (arr[l] < arr[r]) {
                tmp[k++] = arr[l++];
            }
            else {
                tmp[k++] = arr[r++];
            }
        }

        while (l <= middle) {
            tmp[k++] = arr[l++];
        }

        while (r <= right) {
            tmp[k++] = arr[r++];
        }

        for (int i=left; i<= right; i++) {
            arr[i] = tmp[i];
        }
    }
}
