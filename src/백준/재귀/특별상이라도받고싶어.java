package 백준.재귀;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 특별상이라도받고싶어 {

    static int[][] chair;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());


        chair = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                chair[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(divisionChair(0, 0, n));

    }

    static int divisionChair(int startRow, int startCol, int size) {

        int[] arr = new int[4];

        if (size == 1) {
            return chair[startRow][startCol];
        }
        else {
            arr[0] = divisionChair(startRow, startCol, size/2);
            arr[1] = divisionChair(startRow, startCol + size/2, size/2);
            arr[2] = divisionChair(startRow + size/2, startCol, size/2);
            arr[3] = divisionChair(startRow + size/2, startCol + size/2, size/2);

            Arrays.sort(arr);
            return arr[1];
        }
    }

}
