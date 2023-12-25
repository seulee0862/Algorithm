package 백준.기하학;

import java.io.*;

public class 사분면고르기 {

    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            if (x > 0) {
                if (y > 0) System.out.println(1);
                else System.out.println(4);
            } else {
                if (y < 0) System.out.println(3);
                else System.out.println(2);
            }
        }
}
