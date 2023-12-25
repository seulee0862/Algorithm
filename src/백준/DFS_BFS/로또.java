package 백준.DFS_BFS;

import java.io.*;

public class 로또 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int k;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        while (true) {

            String testCase = br.readLine();
            if (testCase.equals("0")) {
                break;
            }

            String[] input = testCase.split(" ");
            k = Integer.parseInt(input[0]);
            arr = new int[k];
            visit = new boolean[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(input[i+1]);
            }

            solution(0, 0);

            bw.write("\n");
        }
        bw.close();
    }

    static void solution(int depth, int startIdx) throws IOException {

        if (depth == 6) {
            for (int i=0; i<k; i++) {
                if (visit[i]) {
                    bw.write(arr[i]+" ");
                }
            }
            bw.write("\n");
        }

        for (int i = startIdx; i < k ; i++) {
            visit[i] = true;
            solution(depth + 1, i + 1);
            visit[i] = false;
        }

    }
}
