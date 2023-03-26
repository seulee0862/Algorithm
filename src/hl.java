import java.io.*;
import java.util.StringTokenizer;

public class hl {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // A의 행렬 N과 M을 받는다
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // A[][]를 만든다
        int[][] A = new int[N][M];
        // N번만큼 반복하면서 A를 초기화 한다
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        // B의 행렬 V와 K가 주워진다
        int V = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // B[][] 를만든다
        int[][] B = new int[V][K];
        // V번 반복하면서 B를 초기화한다
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // N개의 열한개를 각각의 K열에 곱하는 과정을 반복한다.
        // N번 반복한다
        // K번 반복한다
        // M번 반복한다
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    int value = A[i][k] * B[k][j];
                    if (k != M-1)
                        bw.write(value + " ");
                    else
                        bw.write(value + "\n");
                }
            }
        }

        //출력하기
        bw.close();
    }
}
