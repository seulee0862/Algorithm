package 백준.비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거듭제곱 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        long N = Long.parseLong(br.readLine());

        long pow = 1;
        long sum = 0;

        //System.out.println(Integer.toBinaryString((int)N));
        int binaryLen = Long.toBinaryString(N).length();

        for (int i = 0; i < binaryLen; i++) {
            if ((N & 1) == 1) {
                sum += pow;
            }
            N = N >> 1;
            pow *= 3;
        }

        System.out.println(sum);
    }
}

