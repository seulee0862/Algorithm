import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[][]  sameNumCheck;
    static int[][]      aArr;
    static int          n, m;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sameNumCheck = new boolean[n][m];
        aArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String numStr = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = numStr.charAt(j) - 48;
                aArr[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            String numStr = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = numStr.charAt(j) - 48;
                if (aArr[i][j] == num) {
                    sameNumCheck[i][j] = true;
                }
                else {
                    sameNumCheck[i][j] = false;
                }
            }
        }


    }
}
