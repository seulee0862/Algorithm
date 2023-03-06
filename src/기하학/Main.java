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

        int dis = 0;
        for (int i = 1; i < n; i++) {
            dis += Math.abs(arr[i-1][0] - arr[i][0]) + Math.abs(arr[i-1][1] - arr[i][1]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n-1; i++) {

            int a = Math.abs(arr[i - 1][0] - arr[i][0]) + Math.abs(arr[i-1][1] - arr[i][1]);
            int b = Math.abs(arr[i][0] - arr[i+1][0]) + Math.abs(arr[i][1] - arr[i+1][1]);
            int c = Math.abs(arr[i-1][0] - arr[i+1][0]) + Math.abs(arr[i-1][1] - arr[i+1][1]);
            max = Math.max(max, (a+b)-c);
        }

        System.out.println(dis - max);
    }

}
