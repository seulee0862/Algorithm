package 백준.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입사원 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine());
            Score[] arr = new Score[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int aScore = Integer.parseInt(st.nextToken());
                int bScore = Integer.parseInt(st.nextToken());

                arr[i] = new Score(aScore, bScore);
            }

            Arrays.sort(arr);

            int count = 1;
            int min = arr[0].bScore;
            for (int i = 1; i < N; i++) {
                if (arr[i].bScore < min) {
                    count++;
                    min = arr[i].bScore;
                }
            }

            bw.write(count+"\n");
        }

        bw.close();
    }


    static class Score implements Comparable<Score> {

        int aScore;
        int bScore;

        public Score(int aScore, int bScore) {
            this.aScore = aScore;
            this.bScore = bScore;
        }

        @Override
        public int compareTo(Score o) {

            return this.aScore - o.aScore;
        }
    }
}
