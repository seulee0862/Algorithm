package stack_queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 중력큐 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static Deque<String>    deque = new ArrayDeque<>();
    static int              dequeDirectrion  = 3; // queue의 끝부분 시계방향
    static int              ball = 0;
    static int              screen = 0;

    public static void main(String[] args) throws IOException {

        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            String input = br.readLine();
            start(input);

//            System.out.println("input = "+ input+" i = " + i + " ball = "+ ball + " screen = " + screen);
//            System.out.println("roateDirection = " + dequeDirectrion + "\n");
        }

        bw.close();

    }

    public static void start(String input) throws IOException {

        switch (input) {
            case "push b" :
                deque.offerFirst("ball");
                ball++;
                gravityPop();
                break;
            case "push w" :
                deque.offerFirst("screen");
                screen++;
                break;
            case "pop" :
                if (!deque.isEmpty()) {
                    String obj = deque.pollLast();
                    dequePop(obj);
                }
                gravityPop();
                break;
            case "rotate l" :
                rotateLeft();
                gravityPop();
                break;
            case "rotate r" :
                rotateRight();
                gravityPop();
                break;
            case "count b" :
                bw.write(ball + "\n");
                break;
            case "count w" :
                bw.write(screen + "\n");
                break;
        }
    }

    private static void gravityPop() {

        if (deque.isEmpty()) {
            return;
        }

        if (dequeDirectrion == 6) {
            String peekLastObj = deque.peekLast();
            while (!peekLastObj.equals("screen")) {
                String obj = deque.pollLast();
                dequePop(obj);

                if (deque.isEmpty()) {
                    break;
                }
                peekLastObj = deque.peekLast();
            }
        }
        if (dequeDirectrion == 12) {
            String peekFirstObj = deque.peekFirst();
            while (!peekFirstObj.equals("screen")) {

                String obj = deque.pollFirst();
                dequePop(obj);

                if (deque.isEmpty()) {
                    break;
                }

                peekFirstObj = deque.peekFirst();
            }
        }
    }

    private static void rotateRight() {
        if (dequeDirectrion == 12) {
            dequeDirectrion = 3;
        }
        else {
            dequeDirectrion += 3;
        }
    }

    private static void rotateLeft() {
        if (dequeDirectrion == 3) {
            dequeDirectrion = 12;
        }
        else {
            dequeDirectrion -= 3;
        }
    }

    private static void dequePop(String obj) {
        if (obj.equals("ball")) {
            ball--;
        }
        else {
            screen--;
        }
    }

}
