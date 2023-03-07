package 수학;

import java.io.*;
import java.util.StringTokenizer;

public class 언더프라임 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int max = B+1;
        int answer = 0;
        int[] primes = new int[max];
        primes[0] = 1;
        primes[1] = 1;

        for (int i = 2; i < max; i++) {
            if (primes[i] == 0) {
                for (int j = 2*i; j < max; j += i) {
                    int tmp = j;
                    while (tmp % i == 0) {
                        primes[j]++;
                        tmp /= i;
                    }
                }
            }

            if (i>=A && primes[primes[i]] == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
