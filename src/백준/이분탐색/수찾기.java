package 백준.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] mArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);
        int count = 0;
        for (int i = 0; i < M; i++) {
            bw.write(isFindedNum(N, nArr, mArr[i])+"\n");
        }

        bw.close();
    }

    private static int isFindedNum(int N, int[] nArr, int num) {
        int start = 0, end = N - 1;
        while (start <= end) {
            int mIdx = (start + end) / 2;
            int m = nArr[mIdx];
            if (m > num) {
                end = mIdx - 1;
            } else if (m < num) {
                start = mIdx + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
