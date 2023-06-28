package stack_queue;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int height = Integer.parseInt(st.nextToken());
            int target = 0;

            while (!stack.empty()) {

                if (stack.peek()[1] >= height) {
                    target = stack.peek()[0];
                    break;
                }

                stack.pop();
            }

            bw.write(target + " ");
            stack.add(new int[]{i+1, height});
        }

        bw.close();
    }

//    public static void main(String[] args) throws IOException {
//
//        int N = Integer.parseInt(br.readLine());
//        int[] top = new int[N];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            top[i] = Integer.parseInt(st.nextToken());
//        }
//
//        bw.write("0 ");
//        for (int i = 1; i < N; i++) {
//            int hitTop = 0;
//            for (int j = i-1; j >= 0; j--) {
//                if (top[i] <= top[j]) {
//                    hitTop = j + 1;
//                    break;
//                }
//            }
//            bw.write(hitTop + " ");
//        }
//
//        bw.close();
//    }
}
