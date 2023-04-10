import java.io.*;
import java.util.Arrays;

public class 등수매기기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        int[] expectRank = new int[N];
        long badEmotion = 0;

        for (int i = 0; i < N; i++) {
            expectRank[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expectRank);

        for (int i = 0; i < N; i++) {
            //System.out.println(expectRank[i] + "   " + i);
            badEmotion += Math.abs(expectRank[i] - (i + 1));
        }

        System.out.println(badEmotion);
    }
}
