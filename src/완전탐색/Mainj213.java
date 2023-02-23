package 완전탐색;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 *  입력값
 *
 *  N개의 수열
 *  가능한 사칙연산의 갯수
 *
 *  출력값
 *  N개의 수열과 사칙연산으로 만들 수 있는 값중의 최대값, 최소값 출력
 *
 *  조건
 *  사칙연산 우선순위 적용없이 앞에서부터 계산, 숫자위치 안바뀜
 */
public class Mainj213 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());

        String[] operator = new String[n-1];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        for (int i=0; i<4; i++) {
            int x = Integer.parseInt(st.nextToken());
            for (int j=0; j<x; j++) {
                if (i == 0) operator[index++] = "+";
                if (i == 1) operator[index++] = "-";
                if (i == 2) operator[index++] = "*";
                if (i == 3) operator[index++] = "/";
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int count = 0;
        while (count < n-1) {

            int sum = num[0];
            for (int i=1; i<n; i++) {
                if (operator[(count+i-1) % (n-1)].equals("+")) sum += num[i];
                if (operator[(count+i-1) % (n-1)].equals("-")) sum -= num[i];
                if (operator[(count+i-1) % (n-1)].equals("*")) sum *= num[i];
                if (operator[(count+i-1) % (n-1)].equals("/")) sum /= num[i];
            }
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            count++;
        }

        bw.write(max+"\n"+min);
        bw.close();
    }
}
