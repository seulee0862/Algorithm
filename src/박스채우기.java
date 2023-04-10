import java.io.*;
import java.util.StringTokenizer;

public class 박스채우기 {

    static int length, width, height;
    static int[] cubes;
    static boolean flag;
    static int N;
    static int minCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        cubes = new int[20];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            cubes[idx] = count;
        }

        solution(length, width, height);

        if (flag) {
            System.out.println(minCount);
            return;
        }

        System.out.println(-1);

    }

    public static void solution(int l, int w, int h) {

//        System.out.print("l = " + l);
//        System.out.print("  w = " + w);
//        System.out.println("  h = " + h);
        if (l == 0 || w == 0 || h == 0) {
            return;
        }

        flag =false;

        int cubeLen = 0;
        for (int i = 19; i >= 0 ; i--) {
            if (cubes[i] == 0) {
                continue;
            }

            cubeLen = 1 << i;

            if (l >= cubeLen && w >= cubeLen && h >= cubeLen) {
                cubes[i]--;
                minCount++;
                flag = true;

                break;
            }
        }

        if (!flag) {
            return;
        }

        solution(cubeLen, w - cubeLen, cubeLen);
        solution(l - cubeLen, w, cubeLen);
        solution(l, w, h - cubeLen);
    }
}