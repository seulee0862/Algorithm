package stack_queue;

import java.util.Stack;

public class 올바른괄호 {

    /**
     *
     * https://school.programmers.co.kr/learn/courses/30/lessons/12909
     *
     * 문제 설명
     * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
     *
     * "()()" 또는 "(())()" 는 올바른 괄호입니다.
     * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
     * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
     *
     * 제한사항
     * 문자열 s의 길이 : 100,000 이하의 자연수
     * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
     */
    /**
     *
     *  1. 문자열 s를 Stack에 담는다
     *  2. count 변수 0으로 초기화
     *  3. stack에서 하나씩 pop() -> '('는 +1 , ')'는 -1
     *  4. count가 음수가 되는순간 false리턴
     *  5. 반복문 종류후 count가 0이 아니라면 false리턴
     */

    public static void main(String[] args) {
        올바른괄호 main = new 올바른괄호();
        String s = ")()(";
        System.out.println(main.solution(s));
    }

    boolean solution(String s) {
        boolean answer = true;
        int count = 0;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.add(c);
        }

        while (!stack.empty()) {
            if (stack.pop() == ')') count++;
            else count--;
            if (count < 0) return false;
        }

        if (count != 0) answer = false;
        return answer;
    }
}
