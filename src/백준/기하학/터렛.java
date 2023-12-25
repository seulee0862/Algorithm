package 백준.기하학;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  두점사이의 거리구하는 공식쓸때 Math.sqrt쓰면 부동소수점 ㄱ계산방식으로 인한 오류
 *  발생이나서 d^2 형태로 쓰는것과
 *
 *  문제이해, 단순 기하문제
 */

public class 터렛 {

    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Turret turret1;
        Turret turret2;
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            turret1 = new Turret(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
            turret2 = new Turret(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            bw.write(searchMarin(turret1, turret2) + "\n");
        }

        bw.close();
    }

    static int searchMarin(Turret turret1, Turret turret2) {

        // 두점사이의 거리 d 대신 d^2  -> 부동소수점 방식 때문에 // 반지름도 제곱해서 사용
        int distance_pow = (int)(Math.pow(turret1.x - turret2.x, 2)
                + Math.pow(turret1.y - turret2.y, 2));

        // 반지름 r1, r2

        //두 원의 중심이 같고, 반지름도 같을때 -> 무한개
        if (turret1.x == turret2.x && turret1.y == turret2.y && turret1.r == turret2.r) {
            return -1;
        }

        //두 점 사이의 거리가 각 원의 반지름의 합보다 클 때 -> 접정 없음
        else if (distance_pow > Math.pow(turret1.r + turret2.r, 2)) {
            return 0;
        }

        //반 지름의 차의 절대값이 두원의 중점간 거리보다 크면 -> 접점없음
        else if (distance_pow < Math.pow(turret1.r - turret2.r, 2)) {
            return 0;
        }

        //반 지름의 차의 절대값이 두원의 중저간 거리랑 같으면 -> 내접 1개
        else if (distance_pow == Math.pow(turret1.r - turret2.r, 2)) {
            return 1;
        }

        //두 반지름의 합과 두 원의 중점간 거리가 같으면 내접 1개
        else if (distance_pow == Math.pow(turret1.r + turret2.r, 2)) {
            return 1;
        }

        //두 반지름의 합보다 두 원의 중점간의 거리가 더 클때
        else {
            return 2;
        }
    }
}

class Turret {

    int x;
    int y;
    int r;

    public Turret(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
