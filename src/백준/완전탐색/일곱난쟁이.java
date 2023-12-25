package 백준.완전탐색;

import java.io.*;
import java.util.Arrays;

/**
 * 입력값
 * 9명의 키
 *
 * 출력값
 * 합이 100이되는 키를 오름차순으로 출력
 */

/**
 * 9개의 합을 구한다
 * 2명을 뺐을때 100이되는 경우를 찾기위해 2중포문
 */
public class 일곱난쟁이 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalHeight = 0;

        int[] arr = new int[9];
        for (int i=0; i<9; i++) {
            int h = Integer.parseInt(br.readLine());
            arr[i] = h;
            totalHeight += h;
        }
        Arrays.sort(arr);

        end : for (int i=0; i<8; i++) {
            for (int j=i+1; j<9; j++) {
                if (100 == totalHeight - arr[i] - arr[j]) {
                    for (int k=0; k<9; k++) {
                        if (k != i && k != j)
                            bw.write(arr[k]+"\n");
                    }
                    break end;
                }
            }
        }

        bw.close();
    }
}
