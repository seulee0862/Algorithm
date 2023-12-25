package 백준.완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 꽃길 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][]      arr;
    static boolean[][]  check;
    static int          answer = Integer.MAX_VALUE, cost = 0, N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int count) {

        if (count == 3) {
            answer = Math.min(answer, cost);
        }
        else {

            for (int i = 1; i < N-1; i++) {
                for (int j = 1; j < N-1; j++) {

                    if (!existSeed(i, j)) {
                        plantSeed(i, j);
                        plusCost(i, j);

                        dfs( count + 1);

                        plantSeedCancel(i, j);
                        minusCost(i, j);
                    }
                }
            }
        }
    }

    private static void plantSeed(int x, int y) {
        check[x][y] = true;
        check[x -1][y] = true;
        check[x][y +1] = true;
        check[x +1][y] = true;
        check[x][y -1] = true;
    }
    private static void plantSeedCancel(int x, int y) {
        check[x][y] = false;
        check[x -1][y] = false;
        check[x][y +1] = false;
        check[x +1][y] = false;
        check[x][y -1] = false;
    }

    private static boolean existSeed(int x, int y) {
        return check[x][y]
                || check[x - 1][y]
                || check[x][y + 1]
                || check[x + 1][y]
                || check[x][y - 1];
    }

    private static void plusCost(int x, int y) {
        cost += arr[x][y];
        cost += arr[x -1][y];
        cost += arr[x][y +1];
        cost += arr[x +1][y];
        cost += arr[x][y -1];
    }

    private static void minusCost(int x, int y) {
        cost -= arr[x][y];
        cost -= arr[x -1][y];
        cost -= arr[x][y +1];
        cost -= arr[x +1][y];
        cost -= arr[x][y -1];
    }

}
