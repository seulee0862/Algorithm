package 백준.완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 행렬 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[][]  sameNumCheck;
    static int[][]      aArr, bArr;
    static int          n, m, count = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sameNumCheck = new boolean[n][m];
        aArr = new int[n][m];
        bArr = new int[n][m];

        fillAArr();
        fillBArr();

        solution();
        boolean flag = checkArr();

        if (flag) {
            System.out.println(count);
        }
        else{
            System.out.println(-1);
        }

    }

    private static void fillBArr() throws IOException {
        for (int i = 0; i < n; i++) {
            String numStr = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = numStr.charAt(j) - 48;
                bArr[i][j] = num;
            }
        }
    }

    private static void fillAArr() throws IOException {
        for (int i = 0; i < n; i++) {
            String numStr = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = numStr.charAt(j) - 48;
                aArr[i][j] = num;
            }
        }
    }

    private static boolean checkArr() {
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (aArr[i][j] != bArr[i][j]) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    private static void solution() {
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {

//                System.out.println("i = "+ i + " j = "+ j);
//                System.out.println("aArr[i][j] = " + aArr[i][j] + "  bArr[i][j] = " + bArr[i][j]);
                if (aArr[i][j] != bArr[i][j]) {
                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l < j+3; l++) {
                            int num = aArr[k][l];
                            if (num == 0) {
                                aArr[k][l] = 1;
                            }
                            else {
                                aArr[k][l] = 0;
                            }
                        }
                    }
//                    System.out.println("change aArr[i][j] = " + aArr[i][j] + "  bArr[i][j] = " + bArr[i][j]);
                    count++;
                }
//                System.out.println("count = " + count);
//                System.out.println();

            }
        }
    }
}
