package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibo {

    static int[] ch;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ch = new int[n+3];
        ch[0] = 0;
        ch[1] = 1;
        ch[2] = 1;

        System.out.println(fibo(n));
    }

    static int fibo(int n) {


        for (int i=2; i<=n; i++) {
            ch[i] = ch[i-1] + ch[i-2];
        }

        return ch[n];
    }
}
