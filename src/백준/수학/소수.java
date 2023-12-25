package 백준.수학;

import java.io.*;

public class 소수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int priems[] = new int[N+1];
        int sum = 0;
        int min = 0;

        for (int i = 2; i < N+1; i++) {
            if (priems[i] == 0) {
                for (int j = i+i; j < N+1; j += i) {
                    priems[j] = 1;
                }
                if (i >= M && sum == 0) min = i;
                if (i >= M) sum += i;
            }
        }

        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
