package 수학;

import java.util.Scanner;

/**
 *
 *  문제 https://www.acmicpc.net/problem/2292
 *
 *  위의 그림과 같이 육각형으로 이루어진 벌집이 있다.
 *  그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는
 *  방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
 *  숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소
 *  개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를
 *  계산하는 프로그램을 작성하시오.
 *  예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
 *
 *  1 개   1
 *  6 개   7
 *  12 개  19
 *  18 개  37
 *  24 개  61
 *
 *  an = a + (n-1)d 라고 표현할때
 *  Sn(=sum) = a + a+d + .. + a+(n-1)d) 로표현되고 우변을 뒤집어서 더해주면
 *  2Sn = n{2a+(n-1)d} 라는 값을 도출해낼수 있다
 *
 *
 *
 *  위의 규칙성을 응용해서 아래와 같은 수식을 세워볼 수있다.
 *  -> an = (n-1)d
 *  -> Sn(=sum) = (1 - 1)d + (2 - 1)d + .. + (n - 2)d + (n - 1)d
 *  우변 순서 뒤집기
 *  -> Sn(=sum) = (n - 1)d + (n - 2)d + .. + (2 - 1) + (1 - 1)d
 *  좌변과 우변 더하기
 *  -> 2Sn = n * (n-1)d
 *  -> Sn = (n*(n-1)d)/2
 *  -> Sn = n(n-1)d / 2
 *
 *  이것을 문제로 대입해봤을때
 *  an은 벌집을 둘러싸고있는 n번째 계층만 계산한 방의합 이며
 *  Sn은 벌집을 둘러싸고있는 n번째 계층까지 전부 계산한 방의합이다
 *  여기서 가장 첫번재 1을 초기값으로 설정해준다면
 *
 *  입력값 num이 주어졌을때 num까지 도달하기위해 지나야하는 방의수(=계층의수)는
 *  1 + Sn >= num 을만족하는 n의 최대값이다
 *
 *
 */
public class 등차수열합 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();


        for (int i=1; i<1000000000; i++) {
            //Sn = n(n-1)d / 2
            int Sn = (i*(i-1)*6) / 2;

            if (Sn +1 >= num) {
                System.out.println(i);
                break;
            }
        }
    }
}
