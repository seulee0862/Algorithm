package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  입력값
 *  N
 *  상담에거리는시간, 보수
 *
 *  출력값
 *  가장큰 보수
 */

/**
 *  완전탐색인줄 알았는데 풀다보니 백준.DP 기본문제
 */
public class 퇴사 {

    static int answer = 0;
    static Info[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        arr = new Info[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        recursive(0, 0);

        System.out.println(answer);

    }

    static void recursive(int x, int sum) {

        for (int i=x; i<arr.length; i++) {
            if (i + arr[i].day <= arr.length) {
                recursive(i + arr[i].day, sum + arr[i].price);
                recursive(i+1, sum);
            }
        }

        answer = Math.max(answer, sum);
    }
}

class Info implements Comparable<Info>{

    int day;
    int price;

    public Info(int day, int price) {
        this.day = day;
        this.price = price;
    }

    @Override
    public int compareTo(Info o) {
        return this.day - o.day;
    }
}
