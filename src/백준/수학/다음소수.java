package 백준.수학;

import java.io.*;
import java.math.BigInteger;

public class 다음소수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            long testValue = Long.parseLong(br.readLine());
            BigInteger nextPrimeNumber = new BigInteger(String.valueOf(testValue));

            if (nextPrimeNumber.isProbablePrime(10)) {  // 입력 값이 소수면 그대로 출력
                bw.write(nextPrimeNumber+"\n");
            } else {  // 입력 값이 소수가 아니면 다음 소수를 구해서 출력
                bw.write(nextPrimeNumber.nextProbablePrime()+"\n");
            }
        }

        bw.close();
    }
}