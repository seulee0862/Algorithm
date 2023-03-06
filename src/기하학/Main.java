package 기하학;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n-1; i++) {
            int x = arr[0][0];
            int y = arr[0][1];
            int dis = 0;
            for (int j = 1; j < n-1; j++) {
                if (j == i) continue;
                dis += Math.abs(arr[j][0] - x) + Math.abs(arr[j][1] - y);
                x = arr[j][0];
                y = arr[j][1];
            }
            dis += Math.abs(arr[n-1][0] - x) + Math.abs(arr[n-1][1] - y);
            answer = Math.min(answer, dis);
        }

        System.out.println(answer);
    }
}
