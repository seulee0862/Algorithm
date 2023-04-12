import java.io.*;
import java.util.*;

public class 카드합체 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> cardQ = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cardQ.offer((long) Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {

            long aCard = cardQ.poll();
            long bCard = cardQ.poll();
            long cardSum = aCard + bCard;

            cardQ.offer(cardSum);
            cardQ.offer(cardSum);
        }

        long sum = 0;
        while (!cardQ.isEmpty()) {
            sum += cardQ.poll();
        }

        System.out.println(sum);
    }
}
