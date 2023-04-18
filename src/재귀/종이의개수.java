package 재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 종이의개수 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][]  arr;
    static int      N;
    static int[]    answer = new int[3];

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //printArr();

        search(0, 0, N);

        bw.write(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
        bw.close();
    }

    private static void printArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n--- Arr Print End ---\n");
    }

    static void search(int x, int y, int currentSize) {

        int firstPaperColor = arr[x][y];

        //System.out.println("x = " + x + " / y = " + y + " / currentSize = " + currentSize + " / fiirstColor = " + firstPaperColor);
        //System.out.println("answer[0] = "+ answer[0] + " / answer[1] = " + answer[1] + " / arr[2] = " + answer[2]);

        if (currentSize == 1) {
            //System.out.println("1번 조건\n");
            writeAnser(firstPaperColor);
            return;
        }
        if (check(x, y, currentSize, firstPaperColor)) {
            //System.out.println("2번 조건\n");
            writeAnser(firstPaperColor);
            return;
        }

        //System.out.println("분할 시작\n");
        int newSize = currentSize/3;

        int x2 = x + (newSize);
        int x3 = x + ((newSize) * 2);
        int y2 = y + (newSize);
        int y3 = y + ((newSize) * 2);

        search(x, y, newSize);
        search(x, y2, newSize);
        search(x, y3, newSize);

        search(x2, y, newSize);
        search(x2, y2, newSize);
        search(x2, y3, newSize);

        search(x3, y, newSize);
        search(x3, y2, newSize);
        search(x3, y3, newSize);

    }

    static boolean check(int x, int y, int currentSize, int firstPaperColor) {

        for (int i = x; i < x + currentSize; i++) {
            for (int j = y; j < y + currentSize; j++) {
                if (arr[i][j] != firstPaperColor) {
                    return false;
                }
            }
        }

        return true;
    }

    static void writeAnser(int paperColor) {

        if (paperColor == -1) {
            answer[0]++;
        } else if (paperColor == 0) {
            answer[1]++;
        } else {
            answer[2]++;
        }
    }
}
