package 백준.구현;

import java.io.*;

public class 쿠키의신체측정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N입력 받는다
        int N = Integer.parseInt(br.readLine());
        //[N+1][N+1] 배열생성
        String[][] cookieBoard = new String[N+1][N+1];

        boolean findedHead = false;
        int[] head = new int[2];
        int[] heart = new int[2];
        //배열 초기화 과정에서 가장먼저 입력된 * 을통해서 머리랑, 심장 위치저장
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {

                String cookie = String.valueOf(str.charAt(j-1));
                if (!findedHead && cookie.equals("*")) {
                    head[0] = i;
                    head[1] = j;
                    heart[0] = i+1;
                    heart[1] = j;
                    findedHead = true;
                }
                cookieBoard[i][j] = cookie;
            }
        }

        int heartX = heart[0];
        int heartY = heart[1];

        int moveIdx = heartY-1;
        //왼쪽 -> 1이상이고 * 일때까지 심장왼쪽으로 계산
        int leftArm = 0;
        while (moveIdx >= 1 && cookieBoard[heartX][moveIdx].equals("*")) {
            moveIdx--;
            leftArm++;
        }

        moveIdx = heartY+1;
        //오른쪽 -> N이하이고 *일때까지 심장 오른쪽으로 계산
        int rightArm = 0;
        while (moveIdx <= N && cookieBoard[heartX][moveIdx].equals("*")) {

            moveIdx++;
            rightArm++;
        }
        moveIdx = heartY;

        //허리 -> _ 나올떄까지 심장 아래로 계산 이때 _의 위치저장
        moveIdx = heartX + 1;
        int waist = 0;
        while (cookieBoard[moveIdx][heartY].equals("*")) {
            moveIdx++;
            waist++;
        }

        int legStart = moveIdx;

        moveIdx = legStart;
        int leftLeg = 0;
        while ( moveIdx <= N && cookieBoard[moveIdx][heartY-1].equals("*"))  {
            moveIdx++;
            leftLeg++;
        }

        moveIdx = legStart;
        int rightLeg = 0;
        while (moveIdx <= N && cookieBoard[moveIdx][heartY+1].equals("*")) {
            moveIdx++;
            rightLeg++;
        }

        bw.write(heart[0] +" " + heart[1] + "\n");
        bw.write(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);

        bw.close();
    }
}
