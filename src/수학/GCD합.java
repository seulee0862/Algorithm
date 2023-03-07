package 수학;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GCD합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            long sum = 0L; //!!
            for (int j = 0; j < m-1; j++) {
                for (int k = j+1; k < m; k++) {
                    sum += getGCD(arr[j], arr[k]);
                }
            }
            bw.write(sum + "\n");
        }

        bw.close();
    }

    static int getGCD(int n1, int n2) {

         if (n2 % n1 == 0) {
             return n1;
         }
         else {
             return getGCD(n2 % n1, n1);
         }
    }
}
