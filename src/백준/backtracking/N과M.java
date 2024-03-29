package 백준.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class N과M {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] ch, arr;
    static int n, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ch = new int[n];
        arr = new int[m];

        DFS(0, 0);

        bw.close();

    }

    public static void DFS(int D, int idx) throws IOException{

        if (D == m) {
            //출력
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        }
        else {

            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    arr[idx] = i+1;
                    DFS(D+1, idx+1);
                    ch[i] = 0;
                }
            }
        }

    }
}
