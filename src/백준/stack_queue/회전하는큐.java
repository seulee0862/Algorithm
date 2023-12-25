package 백준.stack_queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 회전하는큐 {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i=0; i<m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(queue, arr));
    }


    static int solution(Queue<Integer> queue, int[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            int leftMove = 0;
            int rightMove = queue.size();

            while (queue.peek() != arr[i]) {
                queue.add(queue.poll());
                leftMove++;
                rightMove--;
            }
            queue.poll();

            count += Math.min(leftMove, rightMove);
        }

        return count;
    }
}
