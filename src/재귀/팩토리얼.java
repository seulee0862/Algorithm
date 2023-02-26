package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  단순 재귀문제인데 중요하게 배워간게 있다
 *  아래코드는 정답인데
 *
     static void factorial(int L, int sum) {

     if (L == n) {
     answer = sum;
     }
     else {
     factorial(L+1, sum * (L+1));
     }
     }

    해당 코드는 StackOverflow발생이다

    조건이 256MB만 허용인데 재귀함수 호출시 인자가 2개인것떄문에
    Stack의 크기가 2배로 커져서 발생한 것 같다..
    메모리 신경쓰면서 코드를 짜본 경험이 없었는데 메소드 호출시에 필요한
    데이터타입의 크기가 메모리부족, 성능저하에 영향을끼친다는 걸 고려하면서
    코드를 작성 할 필요가 있을 것 같다
 */
public class 팩토리얼 {

    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

       int answer = factorial(1);

        System.out.println(answer);

    }

    static int factorial(int L) {

        if (L == n+1) return 1;
        return L * factorial(L+1);

    }
}
