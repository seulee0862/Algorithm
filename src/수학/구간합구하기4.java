package 수학;

import java.io.*;
import java.util.StringTokenizer;

public class 구간합구하기4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*public static void main(String[] args) {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        arr[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            bw.write(arr[to] - arr[from]);
            bw.newLine();
        }
        bw.close();
    }*/

    static int      N, M;
    static int[]    nArr;
    static int      currentLeftIndex, currentRightIndex;
    static int      sum = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nArr[i] = num;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int leftIndex = Integer.parseInt(st.nextToken()) - 1;
            int rightIndex = Integer.parseInt(st.nextToken()) - 1;

            calculate(leftIndex, rightIndex);
        }

        bw.close();
    }

    static void calculate(int lefIndex, int rightIndex) throws IOException {

        if (sum == 0) {
            for (int i = lefIndex; i <= rightIndex; i++) {
                sum += nArr[i];
            }
            currentLeftIndex = lefIndex;
            currentRightIndex = rightIndex;
        }
        else {
            int leftGap = currentLeftIndex - lefIndex;
            int rightGap = currentRightIndex - rightIndex;

            if (leftGap > 0) {
                for (int i = 0; i < leftGap; i++) {
                    sum += nArr[--currentLeftIndex];
                }
            } else {
                for (int i = 0; i < Math.abs(leftGap); i++) {
                    sum -= nArr[currentLeftIndex++];
                }
            }

            if (rightGap > 0) {
                for (int i = 0; i < rightGap; i++) {
                    sum -= nArr[currentRightIndex--];
                }
            } else {
                for (int i = 0; i < Math.abs(rightGap); i++) {
                    sum += nArr[++currentRightIndex];
                }
            }
        }

        bw.write(sum+"");
        bw.newLine();
    }
}
