import java.io.*;
import java.util.StringTokenizer;

public class Main2 {


    static int      boxSize;
    static int[][]  cubeArr;
    static int      l, w, h;
    static int      N;
    static int      answer = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

    }

    private static void setCube(BufferedReader br, int N) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cubeSize = Integer.parseInt(st.nextToken());
            int cubeNum = Integer.parseInt(st.nextToken());

            cubeArr[i][0] = cubeSize;
            cubeArr[i][1] = cubeNum;
        }
    }
}
