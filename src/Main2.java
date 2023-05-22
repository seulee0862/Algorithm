import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int      N, K;
    static int[][]  jewelArr;
    static int[]    bagArr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelArr = new int[N][2];
        bagArr = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelArr[i][0] = weight;
            jewelArr[i][1] = price;
        }

        for (int i = 0; i < K; i++) {
            int storageCapacity = Integer.parseInt(br.readLine());
            bagArr[i] = storageCapacity;
        }


    }
}
