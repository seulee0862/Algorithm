package 완전탐색;

//Tn = n(n+1)/2

import java.io.*;

/**
 * T0 = 0 ..
 * T1 = 1 ..1 증가
 * T2 = 3 ..2 증가
 * T3 = 6 ..3 증가
 * T4 = 10 ..
 * T5 = 15
 * T6 = 21
 * T7 = 28 .. N증가
 *
 * 3 = 1
 * 4 = 0
 * 5 = 1
 * 6 = 0
 * 7 = 1
 * 8 = 1
 * 9 = 1
 *
 */


public class 유레카이론 {

    static int[] tArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1~45까지의 Tn값을 저장할 tArr을 생성한다
        tArr = new int[46];
        //tArr[1]~[45]까지 Tn의 공식에 맞춰 값을 저장한다
        for (int i = 1; i <= 45; i++) {
            int Ti = i * (i + 1) / 2;
            tArr[i] = Ti;
        }

        //N을 입력받는다
        int N = Integer.parseInt(br.readLine());
        //N번만큼 반복하면서 값을 입력받는다
        for (int i = 0; i < N; i++) {

            int K = Integer.parseInt(br.readLine());
            //입력을 받으면 유레카숫자인지 확인후 1, 0을 bw에 입력한다
            // 3중 반복문을 돌면서 모든 값을 더한다 만약 있다면 1반환 없다면 0반환
            if (isEurekaNum(K)) {
                bw.write( "1\n");
            }
            else {
                bw.write("0\n");
            }

        }

        //출력한다
        bw.close();

    }

    static boolean isEurekaNum(int K) {

        for (int i = 1; i <= 45 ; i++) {
            for (int j = 1; j <= 45; j++) {
                for (int k = 1; k <= 45; k++) {

                    if (K == tArr[i] + tArr[j] +tArr[k]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
