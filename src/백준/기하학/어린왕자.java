package 백준.기하학;

import java.io.*;
import java.util.StringTokenizer;

public class 어린왕자 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            int m = Integer.parseInt(br.readLine());


            int count = 0;
            for (int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());

                int x3 = Integer.parseInt(st.nextToken());
                int y3 = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean flag1 = false;
                boolean flag2 = false;

                if (Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2) < Math.pow(r, 2)) {
                    flag1 = true;
                }

                if (Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2) < Math.pow(r, 2)) {
                    flag2 = true;
                }

                if (flag1 != flag2) count++;

            }
            bw.write(count + "\n");
        }

        bw.close();
    }
}
