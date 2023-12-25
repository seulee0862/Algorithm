package 백준.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operators = new int[4];
    static int[] numbers;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        DFS(numbers[0], 1);

        bw.write(max+"\n"+min);
        bw.close();
    }

    static void DFS(int num, int D) {

        if (D == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        else {
            for (int i=0; i<4; i++) {

                if (operators[i] > 0) {
                    operators[i] = operators[i] - 1;
                    if (i == 0) DFS(num + numbers[D], D+1);
                    if (i == 1) DFS( num - numbers[D], D+1);
                    if (i == 2) DFS(num * numbers[D], D+1);
                    if (i == 3) DFS(num / numbers[D], D+1);
                    operators[i]++;
                }
            }
        }

    }

}
