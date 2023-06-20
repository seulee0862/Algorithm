package 수학;

import java.io.*;
import java.util.*;

public class 소수구하기 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] primes = new int[N+1];

        for (int i = 2; i < N+1; i++) {
            if (primes[i] == 0) {
                for (int j = i*2; j < N+1; j = j+i) {
                    primes[j] = 1;
                }
                if (i >= M) bw.write(i+"\n");
            }

        }

        bw.close();
    }
}
