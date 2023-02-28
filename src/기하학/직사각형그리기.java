package 기하학;

import java.io.*;
import java.util.StringTokenizer;

public class 직사각형그리기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[2];
        int[] b = new int[2];
        int[] c = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a[0] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        b[0] = Integer.parseInt(st.nextToken());
        b[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c[0] = Integer.parseInt(st.nextToken());
        c[1] = Integer.parseInt(st.nextToken());

        if (a[0] == b[0]) {
            if (a[1] == c[1]) {
                bw.write(c[0]+" "+b[1]);
            }
            else {
                bw.write(c[0]+" "+a[1]);
            }
        }
        else if (a[0] == c[0]) {
            if (a[1] == b[1]) {
                bw.write(b[0]+" "+c[1]);
            }
            else {
                bw.write(b[0]+" "+a[1]);
            }
        }
        else if(b[0] == c[0]) {
            if (b[1] == a[1]) {
                bw.write(a[0]+" "+c[1]);
            }
            else {
                bw.write(a[0]+" "+b[1]);
            }
        }

        bw.close();

    }
}
