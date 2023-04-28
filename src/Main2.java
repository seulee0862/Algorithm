import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        char[] inputArr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        //stack.add(' ');

        boolean flag = false;
        for (int i = 0; i < inputArr.length; i++) {
            char c = inputArr[i];

//            if (c == ' ') {
//                reverseAndSbAppend(stack);
//            }
            //<>
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

            // <
            if (!flag) {
                if (c != '>') {
                    stack.add(c);
                }
            }
        }

//        if (stack.size() == 1) {
//            stack.clear();
//        }
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
