package 백준.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어뒤집기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        char[] inputArr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();


        boolean flag = false;
        for (int i = 0; i < inputArr.length; i++) {
            char c = inputArr[i];

            if (!flag && c == ' ') {
                reverseAndSbAppend(stack);
                sb.append(" ");
                continue;
            }
            if (c == '<') {
                reverseAndSbAppend(stack);

                flag = true;
            }
            if (flag) {
                sb.append(String.valueOf(c));
            }
            if (c == '>') {
                flag = false;
            }

            if (!flag) {
                if (c != '>') {
                    stack.add(c);
                }
            }
        }

        reverseAndSbAppend(stack);

        System.out.println(sb.toString());
    }

    private static void reverseAndSbAppend(Stack<Character> stack) {
        while (!stack.empty()) {
            String str = String.valueOf(stack.pop());
            sb.append(str);
        }
    }

}
