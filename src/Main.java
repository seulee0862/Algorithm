import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /**
         * 2
         * 1
         *
         * 3
         * 1 2
         *
         * 3
         * 0 1 2
         *
         * 4
         * 0 1 2 3
         *
         * 5
         * 0 1 2 3 4
         *
         */

        int rest = N%K;

        if (N <= K) {
            System.out.println(-1);
            return;
        }

        if (K % 2 == 0) {
            if (rest == N/2) {
                System.out.println(K-1);
            }
            else {
                System.out.println(-1);
            }
        }
        else {
            if (rest == 0) {
                System.out.println(K-1);
            }
            else {
                System.out.println(-1);
            }
        }
    }

}
