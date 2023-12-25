package 백준.기하학;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 정사각형 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr = new int[4][2];

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());


        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[j][0] = x;
                arr[j][1] = y;
                xSet.add(x);
                ySet.add(y);
            }

            if (xSet.size() < 2 || ySet.size() < 2) {
                bw.write("0\n");
            }
            else {
                if ( idSquare() ) bw.write("1\n");
                else bw.write("0\n");
            }
        }

        bw.close();
    }

    static boolean idSquare() throws IOException {

        double[] dis = new double[6];

        int idx = 0;
        for (int i=0; i<3; i++) {
            for (int j = i+1; j<4; j++) {
                dis[idx++] = Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2);
            }
        }
        Arrays.sort(dis);


        for (int i=1; i<4; i++) if (dis[0] != dis[i]) {
            return false;
        }

        if (dis[4] != dis[5]) return false;

        return true;
    }

}