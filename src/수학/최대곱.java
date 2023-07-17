package 수학;

import java.io.*;
import java.util.*;

public class 최대곱 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        long answer = 1;
        st = new StringTokenizer(br.readLine());

        int S       = Integer.parseInt(st.nextToken());
        int K       = Integer.parseInt(st.nextToken());
        int[] arr   = new int[K];

//        System.out.println("S = " + S);
//        System.out.println("S/K = " + S/K);
//        System.out.println("S%K = " + S%K);

        // 10 3 - 7/3  1
        S = S - K;
        Arrays.fill(arr, ((S/K) * 1));

        for (int i = 0; i < S%K; i++) {
            arr[i] = arr[i] + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            answer += answer * arr[i];
        }

        System.out.println(answer);
    }
}
