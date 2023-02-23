package 정렬;

import java.io.*;

/**
 *
 *  길이오름차순 > (숫자만)모든수합 오름차순 > 알파벳 오름차순
 */
public class Main {

    static Serial[] tmpArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        tmpArr = new Serial[n];
        Serial[] arr = new Serial[n];
        for (int i=0; i<n; i++) {
            arr[i] = new Serial(br.readLine());
        }
        mergeSort(arr, 0, arr.length-1);
        //Arrays.sort(arr);

        for (Serial str : arr) {
            bw.write(str.num+"\n");
        }
        bw.close();

    }

    static void mergeSort (Serial[] arr, int left, int right) {

        if (left < right) {

            int middle = (left+right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);

            merge(arr, left, middle, right);
        }
    }

    static void merge(Serial[] arr, int left, int middle, int right) {

        int l = left;
        int r = middle+1;
        int k = left;

        while (l <= middle && r <= right) {

            if (arr[l].compareTo(arr[r]) < 0) tmpArr[k++] = arr[l++];
            else tmpArr[k++] = arr[r++];
        }

        while (l <= middle) tmpArr[k++] = arr[l++];

        while (r <= right) tmpArr[k++] = arr[r++];

        for (int i=left; i<=right; i++) {
            arr[i] = tmpArr[i];
        }
    }
}

class Serial implements Comparable<Serial>{

    String num;

    public Serial(String num) {
        this.num = num;
    }

    @Override
    public int compareTo(Serial o) {

        /**
         *  리팩토링 배웠음~~
         */
        int result;
        if ((result = this.num.length() - o.num.length() ) != 0) return result;
        if ((result = hap(this.num) - hap(o.num)) != 0) return result;

        return this.num.compareTo(o.num);
    }

    int hap(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (48<= c && c <= 57) {
                sum += c-48;
            }
        }
        return sum;
    }
}