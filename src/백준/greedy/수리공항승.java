package 백준.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수리공항승 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        int position;
        int tape = 0;

        for (int i = 0; i < N; i++) {

            position = arr[i];
            if (position > tape) {
                tape = position + L - 1;
                count++;
            }
        }

        System.out.println(count);

    }
}
