import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int AN  = Integer.parseInt(st.nextToken());
        int AM  = Integer.parseInt(st.nextToken());
        int[][] A = new int[AN][AM];
        for (int i = 0; i < AN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < AM; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int BN  = Integer.parseInt(st.nextToken());
        int BM  = Integer.parseInt(st.nextToken());
        int[][] B = new int[BN][BM];
        for (int i = 0; i < BN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BM; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        /**
         *
         *  1 2   -1 -2 0
         *  3 4    0  0 3
         *  5 6
         *
         * 1 1 1
         * 1 1 1
         *
         *
         *
         */
        for (int i = 0; i < AN; i++) {
            for (int j = 0; j < BM; j++) {
                int sum = 0;
                for (int k = 0; k < AM; k++) {
                    sum += A[i][k] * B[k][j];
                }
                bw.write(sum + " ");
            }
            bw.write("\n");
        }

        bw.close();
    }
}
