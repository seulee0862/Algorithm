package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 입력값
 * N
 * N^2 완전탐색.행렬
 *
 * 출력값
 * 안전한지역 최대값
 *
 * 조건
 *
 * 장마가 1이면 1까지 다잠긴다
 * 장마가 5이면 5까지 다잠긴다
 *
 * 인접해 있는 땅덩어리 1개는 -> 안전한지역 1개다
 *
 * 풀이
 *
 * 장마가 n까지 증가하면서
 * 1증가할때마다 안전한지역 수를 저장한다음에 최대값 출력
 *
 */
public class 안전영역 {

    static int n;
    static int[][] region;
    static boolean[][] safeCheck;

    static int maxRegion = Integer.MIN_VALUE, answer  = Integer.MIN_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        region = new int[n][n];
        safeCheck = new boolean[n][n];

        // 지역정보 받기
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int x = Integer.parseInt(st.nextToken());
                maxRegion = Math.max(maxRegion, x);
                region[i][j] = x;
            }
        }

        solution();

        System.out.println(answer);
    }

    static void solution() {

        // 강수량 1부터 최대안전지역 높이 직전까지 전부 탐색해보기
        for (int rain=0; rain<maxRegion; rain++) {
            raining(rain);
            safeCheck = new boolean[n][n];
        }
    }

    static void raining(int rain) {

        int regionNum = 0;

        // 비내리기
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (region[i][j] > rain) safeCheck[i][j] = true;
            }
        }

        isSafeRegion();
    }

    static void isSafeRegion() {


        // 땅 덩어리 구하기
        Queue<Point> queue = new LinkedList<>();
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (safeCheck[i][j] == true) {
                    queue.offer(new Point(i, j));
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        for (int k=0; k<4; k++) {
                            int nx = point.x + dx[k];
                            int ny = point.y + dy[k];
                            if (nx >= 0 && nx < n
                                && ny >= 0 && ny < n && safeCheck[nx][ny] == true) {
                                safeCheck[nx][ny] = false;
                                queue.offer(new Point(nx, ny));
                            }
                        }
                    }
                    count++;
                }
            }
        }

        answer = Math.max(answer, count);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
