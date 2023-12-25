package 백준.정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 약속 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int waitTime = start - end;

            arr[i] = waitTime;
        }
        Arrays.sort(arr);

        if (N%2 == 1) {
            System.out.println(arr[N/2]);
            return;
        }

        int t1 = arr[(N/2) - 1];
        int t2 = arr[N/2];

        System.out.println(Math.abs(t2 - t1) + 1);

    }
}
