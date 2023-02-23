package 완전탐색;

/**
 *   입력값 N
 *
 *   출력값
 *   N을 만들 수있는 가장 작은 생성자
 *
 *   생성자란? 256 (245+2+4+5) n+각 자리수를 더해서 나오는값 245는 256의 생성자
 */

import java.io.*;

/**
 * 1 ~ N까지 돌면서
 * 생성자 구하기 찾는순간 출력 없으면 0
 */
public class 분해합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i=1; i<=n; i++) {
            if (isConstructor(n, i)) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

    static boolean isConstructor(int n, int m){

        String str = Integer.toString(m);
        int sum = m;
        for (char c : str.toCharArray()) {
            sum += c-48;
        }

        if (sum == n) return true;
        else return false;
    }
}
