package 기하학;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[][] point = new int[4][2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        Set<String> setXY = new HashSet<>();
        for (int i=0; i<n; i++) {

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                setX.add(x);
                setY.add(y);
                setXY.add(String.valueOf(x) + String.valueOf(y));
            }

            if (setXY.size() < 4) bw.write("0\n");
            else {

                if (setX.size() >= 3) bw.write("0\n");
                else {

                    if (setY.size() >= 3 ) bw.write("0\n");
                    else {
                        bw.write("1\n");
                    }
                }
            }
            setX.clear();
            setY.clear();
        }

        bw.close();
    }

}


