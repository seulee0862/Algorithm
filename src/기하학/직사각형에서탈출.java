package 기하학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 두점사이는 루트( (x1-x2)^2 + (y1-y2)^2 );
 */
public class 직사각형에서탈출 {

    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int a = Math.abs(x - w);
            int b = Math.abs(y - h);
            int c = (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

            System.out.println(
                    Math.min(
                            a, Math.min(
                                    b, Math.min(
                                            c, Math.min(x, y)
                                    )
                            )
                    )
            );

        }
}