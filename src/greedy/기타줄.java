package greedy;

import java.io.*;
import java.util.StringTokenizer;

public class 기타줄 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int packageValue = Integer.MAX_VALUE;
        int singleValue = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packageValue = Math.min(packageValue, Integer.parseInt(st.nextToken()));
            singleValue = Math.min(singleValue, Integer.parseInt(st.nextToken()));
        }

        System.out.println(pay(N, packageValue, singleValue));
    }

    static int pay(int N, int pacakageValue, int singleValue) {

        int quotient = N/6;
        int rest = N%6;

        return Math.min((quotient+1) * pacakageValue,
                Math.min((quotient * pacakageValue) + (rest * singleValue)
                        , singleValue * N));
    }
}
