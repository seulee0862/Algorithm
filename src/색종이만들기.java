import java.io.*;
import java.util.StringTokenizer;

public class 색종이만들기 {

    static int[][] board;
    static int whiteNum = 0, blueNum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N을 입력받는다
        int N = Integer.parseInt(br.readLine());
        //N*N크기의 배열을 생성후 값을 초기화한다.
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //whiteNum, BlueNum 0으로 초기화

        //재귀함수 호출 (x, y, N ) 전달 // x, y, 검사할 사각형 산변 길이
        search(0, 0, N);

        //하얀종이 개수 출력
        //파란종이 개수 출력
        bw.write(whiteNum + "\n" + blueNum);
        bw.close();
    }

    static void search(int row, int col, int currentSize) {

        int temp = board[row][col];
        //시작지점의 값이 N*N의 배열을 전부돌면서 전부 일치하거나 정사각형 크기가 1이라면
        if (colorIsSame(row, col, currentSize, temp)) {
            //1일경우 파란종이, 0일경우 하얀종이의 값 1증가후 return
            if (temp == 1)
                blueNum++;
            else
                whiteNum++;
            return;
        }

        //만약 다르다면

        int reSize = currentSize / 2;
        // 재귀함수 호출( 0, 0, N/2)
        search(row, col, reSize);
        // 재귀함수 호출( x + N/2, 0, N/2)
        search(row, col + reSize, reSize);
        // 재귀함수 호출( 0, y + N/2, N/2)
        search(row + reSize, col, reSize);
        // 재귀함수 호출( x + N/2, y + N/2, N/2)
        search(row + reSize, col + reSize, reSize);

    }

    static boolean colorIsSame(int row, int col, int currentSize, int color) {

        for (int i = row; i < row + currentSize; i++) {
            for (int j = col; j < col + currentSize; j++) {
                if (color != board[i][j]) return false;
            }
        }

        return true;
    }
}