package stack_queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //bw 시작
        bw.write("<");

        st = new StringTokenizer(br.readLine());
        // N입력
        int N = Integer.parseInt(st.nextToken());
        // 1~N의 자연수를 Queued에 입력
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            queue.offer(i);
        }
        // K입력
        int K = Integer.parseInt(st.nextToken());
        //큐 size 1일때까지 반복
        while (queue.size() != 1) {
            // poll, offer K-1번 실행후
            int idx = 0;
            while (idx++ < K-1){
                queue.add(queue.poll());
            }
            // K번째는 poll한뒤 bw.wrtie
            bw.write(queue.poll()+", ");
        }

        //마지막 queue와함께 bw입력
        bw.write(queue.poll()+">");
        //출력
        bw.close();
    }
}
