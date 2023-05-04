import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수의정렬 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /**
     *
     * B[P[i]] = A[i]
     */
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        int[] B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(st.nextToken());
            A[i][0] = num;
            A[i][1] = i;
        }

        sort(A);

        // 2 0 1
        for (int i = 0; i < N; i++) {
            int index = A[i][1];
            B[index] = i;
        }

        //B[2] = 0 , B[0] = 1 , B[1] = 2
        for (int i = 0; i < N-1; i++) {
            bw.write(B[i] + " ");
        }

        bw.write(B[N-1]+"");

        bw.close();
    }

    /**
     *
     *
     *
     *      2 0
     *      3 1
     *      1 2
     *
     *      1 2
     *      2 0
     *      3 1
     */
    static void sort (int[][] A) {

        Arrays.sort(A, (current, next) -> {

            if (current[0] < next[0]) {
                return -1;
            }

            else if (current[0] > next[0]) {
                return 1;
            }
            else {
                return Integer.compare(current[1], next[1]);
            }
        });
    }
}
