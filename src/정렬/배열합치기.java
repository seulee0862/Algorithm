package 정렬;

import java.io.*;
import java.util.StringTokenizer;

public class 배열합치기 {

    static int[] sorted;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+m];
        sorted = new int[n+m];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=n; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // Arrays.sort(arr); 성공
        // mergerSort(arr, 0, arr.length-1); 시간초과
        //insertSort(arr);
        quickSort(arr, 0, arr.length-1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int x : arr) {
            bw.write(x+" ");
        }

        bw.close();
    }

    static void insertSort(int[] arr) {

        int tmp;
        int j;

        for (int i=1; i<arr.length; i++) {
            tmp = arr[i];
            for (j=i-1; j>=0; j--) {
                if (arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }
    }

    static void mergerSort(int[] arr, int left ,int right ) {

        if (left < right ) {

            int middle = left + (right-left)/2;

            mergerSort(arr, left, middle);
            mergerSort(arr, middle+1, right);

            merge(arr, left, middle, right);
        }
    }

    static void merge (int[] arr, int left, int middle, int right) {

        int l = left;
        int r = middle + 1;
        int k = left;

        while (l <= middle && r <= right) {

            if (arr[l] < arr[r]) sorted[k++] = arr[l++];
            else sorted[k++] = arr[r++];
        }

        while (l <= middle) sorted[k++] = arr[l++];
        while (r <= right) sorted[k++] = arr[r++];

        for (int i=0; i<= right; i++) arr[i] = sorted[i];
    }

    private static void quickSort(int[] arr,int start, int end) {
        int part=partition(arr,start,end);
        if(start<part-1) quickSort(arr,start,part-1);
        if(end>part) quickSort(arr,part,end);
    }

    private static int partition(int[] arr,int start,int end) {
        int pivot=arr[(start+end)/2];
        while(start<=end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if(start<=end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr,int start,int end) {
        int tmp=arr[start];
        arr[start]=arr[end];
        arr[end]=tmp;
        return;
    }

}
