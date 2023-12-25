package 백준.DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //T을 입력 받는다
        int T = Integer.parseInt(br.readLine());
        //50, 50크기의 배열을 생성한다.
        int[][] land = new int[50][50];
        //T번만큼 알고리즘 출력결과를 출력한다
        while (T-- > 0) {
            //count 0 초기화
            int count = 0;

            //M, N ,K를 입력받는다
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            //K번만큼 반복하면서 해당인덱스에 1을 초기화한다.
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                land[row][col] = 1;
            }

            //N번, M번 반복한다
            Queue<Cordinate> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    //만약 해당 [N][M]이 1이라면 경계면에 닿아있는 모든값 0으로변경후 count 증가
                    //방법 -> queue생성후 좌상우하 전부 확인후 1이면 0으로변경후 해당인덱스 Queue에 저장
                    if (land[i][j] == 1) {
                        land[i][j] = 0;
                        queue.add(new Cordinate(i, j));
                        while (!queue.isEmpty()) {
                            Cordinate cordinate = queue.poll();
                            int x = cordinate.x;
                            int y = cordinate.y;

                            for (int k = 0; k < 4; k++) {
                                int nx =  x + dx[k];
                                int ny =  y + dy[k];

                                if (nx >= 0 && nx <N
                                && ny >= 0 && ny < M
                                && land[nx][ny] == 1) {
                                    queue.add(new Cordinate(nx, ny));
                                    land[nx][ny] = 0;
                                }
                            }
                        }
                        count++;
                    }

                }
            }
            //count 입력
            bw.write(count + "\n");
            // T번반복
        }

        //출력
        bw.close();
    }

    static class Cordinate {

        int x;
        int y;

        public Cordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
