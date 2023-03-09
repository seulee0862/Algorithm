package 수학;

import java.io.*;

public class 베르트랑공준 {

    static int[] primes = new int[250001];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        primes[0] = 1;
        primes[1] = 1;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 0) {
                for (int j = i+i; j < primes.length; j += i) {
                    primes[j] = 1;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            primeNumIs(n);
        }

        bw.close();
    }

    static void primeNumIs(int n) throws IOException{

        int start = n+1;
        int end = 2*n;

        int count = 0;
        for (int i = start; i < end+1; i++) {
            if (primes[i] == 0) count++;
        }

        bw.write(count+"\n");
    }
}
