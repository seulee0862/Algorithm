package 백준.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class 동전0 {
    static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coinArr = new int[N];

        for (int i = 0; i < N; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N -1; i >= 0; i--) {
            int coin = coinArr[i];

            count += K /coin;
            K = K %coin;

            if (K == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}
