package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class N과M2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];

        DFS(0, 0);

        bw.close();

    }

    static void DFS(int D, int idx) throws IOException{

        if (D == M) {
            for (int i = 0; i < N; i++) {
                if (visit[i] == true) {
                    bw.write(i+1 + " ");
                }
            }
            bw.write("\n");
        }
        else {
            for (int i = idx; i <N; i++) {
                if (visit[i] == false) {
                    visit[i] = true;
                    DFS(D+1, i+1);
                    visit[i] = false;
                }
            }
        }
    }
}
