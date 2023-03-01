package 기하학;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * 큰 사각형 - 작은 사각형
 *
 * 1. 큰 사각형 구하기는 쉽다..
 * 2. 입력값이 반시계방향 ( 한방향 )으로 진행된다는 점을 이용해서 작은 사각형의 가로, 세로를 찾았다.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int maxH = 0, maxW = 0;
        int hInx = -1, wInx = -1;

        int[] direction = new int[6];
        int[] dis = new int[6];

        StringTokenizer st;
        for (int i=0; i<6; i++) {

            st = new StringTokenizer(br.readLine());
            direction[i] = Integer.parseInt(st.nextToken());
            dis[i] = Integer.parseInt(st.nextToken());

            if (direction[i] == 1 || direction[i] == 2) {
                if (maxH < dis[i]) {
                    maxH = dis[i];
                    hInx = i;
                }
            }
            else {
                if (maxW < dis[i]) {
                    maxW = dis[i];
                    wInx = i;
                }
            }
        }

        int currentDirection = 0;
        for (int i = 0; i < 6; i++) {

            if (i == hInx || i == wInx) continue;
            currentDirection = dis[i];
        }

        int bigSqaure = maxW * maxH;
        int minSqqure = dis[(wInx + 3) % 6] * dis[(hInx + 3) % 6];

        System.out.println( (bigSqaure - minSqqure) * n );
    }
}
