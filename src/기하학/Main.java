package 기하학;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * 큰 사각형 - 작은 사각형
 *
 * 1. 큰 사각형 구하기는 쉽다..
 * 2. 입력값이 반시계방향 ( 한방향 )으로 진행된다는 점을 이용해서 작은 사각형의 가로, 세로를 찾았다.
 *
 * 기하로 좋은 문제 같아서 다른 풀이 그대로 이해하고 구현도해봄
 *
 * https://good-or-bad.tistory.com/21 코드로도 이해하고 풀어봤는데 아주좋았음음 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[6];
        int maxR = 0, maxC = 0; // maxR = 최대세로, maxC  최대 가로길이
        int indexR = 0, indexC = 0;

        for (int i=0; i<6; i++) {

            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (dir == 3 || dir ==4 ) {
                maxR = maxR < distance ? distance : maxR;
                if ( maxR == distance) indexR = i;
            }
            else {
                maxC = maxC < distance ? distance:maxC;
                if (maxC == distance) indexC = i;
            }
            input[i] = distance;
        }

        int nextR1 = input[5], nextC1 = input[5]; // 세로길이 후보
        int nextR2 = input[0], nextC2 = input[0]; // 가로길이 후보

        /**
         *  한개의 가로에 두개의 세로선이 인접해잇고
         *  반대도 마찬가지라는 점을 이용함!!!
         */
        if (indexC-1 > -1) nextR1 = input[indexC -1];
        if (indexC+1 < 6) nextR2 = input[indexC + 1];
        if (indexR-1 > -1) nextC1 = input[indexR - 1];
        if (indexR+1 < 6) nextC2 = input[indexR + 1];

        // 최대 가로길이*세로길이후보 중 작은 길이 + 가로길이후보 중 작은 길이*(최대 세로길이-세로길이후보 중 작은 길이)
        int area=maxC*Math.min(nextR1, nextR2)+Math.min(nextC1, nextC2)*(maxR-(Math.min(nextR1, nextR2)));

        System.out.println(area*N);

    }

}


    /*public static void main(String[] args) throws IOException {

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
    }*/
