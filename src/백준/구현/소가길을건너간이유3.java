package 백준.구현;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소가길을건너간이유3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 소마리수 입력
        int N = Integer.parseInt(br.readLine());
        //소 입장, 검문시간class생성
        //소 1차원 배열생성
        Cow[] cows = new Cow[N];
        //소 N만큼의 소 초기화
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(t1, t2);
        }
        //소 입장시간 오름차순 백준.정렬
        Arrays.sort(cows);
        // 가장마지막에 도착한 소 도착시간 + 검문시간 or 검문시간 모두 합한값중 가장큰값 출력
        int second = 0;
        for (int i = 0; i < N; i++) {
            second = Math.max(second, cows[i].time1);
            second += cows[i].time2;
        }

        System.out.println(second);
    }
}

class Cow implements Comparable<Cow>{

    int time1;
    int time2;

    public Cow(int time1, int time2) {
        this.time1 = time1;
        this.time2 = time2;
    }

    @Override
    public int compareTo(Cow o) {

        return this.time1 - o.time1;
    }
}