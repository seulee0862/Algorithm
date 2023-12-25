package 백준.수학;

import java.io.*;
import java.util.StringTokenizer;

public class 소수찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] primes = new int[1001];
        primes[0] = 1;
        primes[1] = 1;
        for (int i = 0; i < 501; i++) {
            if (primes[i] == 0) {
                for (int j = i+i; j < 1001; j += i) {
                    primes[j] = 1;
                }
            }
        }

        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (primes[num] == 0) answer++;
        }

        System.out.println(answer);
    }
}
