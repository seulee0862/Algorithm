package 백준.재귀;

import java.io.*;

public class 하노이탑이동순서 {

    /**
     *

     * hanoi(n-1) -> 3개의 도착지점이 있을때 1개의 도착지점에서 다른 1개의 도착지점까지 이동하는수라고 가정

     1. 원판걸이가 ABC가 있다고할때 원판이 A에서 시작하든 B에서시작하든 C에서시작하든
     ABC중하나에서 시작 지점을 제외한 어느곳으로 가는경우도 hanoi(n-1)개이다.

     2. n번째 원판을 옮기는 방법은 1개이다

     * 여기서 하노이 원판을 다 옮기는 방법은 맨 아래 원판을 뺴고 모든원판을 옮긴뒤
       빈 도착지점에 맨아래 원판을 옮기는 방식을 계속 반복해야만한다

     * 3개의 원판을 옮긴다고 치면 2개의 원판을 빈공간으로 옮겨야하고
       1개의 원판을 옮긴뒤
       남은 2개의 원판을 옮겨야한다

     여기서 3개의 원판을 옮긴는데 필요한 방법은
     2개의 원판을 전부 옮기는방법 2가지 , 3번쨰 원판을 옮기는 방법 1가지였다

     3개도 마찬가지고 4개도 마찬기지이다

     여기서 점화식 하나를 이끌어 낼 수 있다
     an = 2 * (an-1) + 1이다
     a1 = 1이다

     -> an+1 = 2an + 1

     여가서 새로운 bn을 정의해보자
     bn = an + 1이라면

     좌변과 우변을 곱한값과
     2bn = 2an + 2

     n의 값을 1증가한 값의 결과가
     b(n+1) = a(n+1) + 1 ( a(n+1) = 2an+1 공식을 대입 )
     b(n+1) = 2an + 2 같다는 것을 알 수 있다.

     즉 2bn = b(n+1) 이라는것인데
     n+1번째의 값이 n번쨰의 값이라는건
     n+1번째의 값이 항상 n번째 값에 2를 곱한것이기에
     bn은 공비가 2인 공비수열에 속한다는 점을 알수있다
     즉 bn은 2^n 이다!!

     bn = an+1로 정의하고 시작했었고

     b1 = a1 + 1 = 2
     b1 = 2인 첫항까지 알아냈기에

     an = bn - 1은
     an = 2^n - 1이라는 공식을 얻어낼 수 있다!! 이렇게해서

     n개의 원판을 전부 옮기기위해서
     hanoi(n-1)을 2번호출하고 1을 더하는것이
     -> an 과 같다는 것을 알수있다

     -- 이동횟수는 해결 --

     -- 문제처럼 출력하기 위해서는 재귀알고리즘이 필요하다 --

     우선 백준.재귀 메커니즘은 이렇다

     n번째 원판을 옮길때까지 재귀를 호출한다
     호출된 메소드 스택이 pop되면서
     n-1번째 원판을 옮길때까지 재귀를 호출한다 ..





     */

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] ars) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        bw.write((int) (Math.pow(2, n) - 1) + "\n");

        hanoi(n ,1, 2, 3);
        bw.flush();
        bw.close();


    }

    /**
     *
     *
     *  하노이 영상을 보면
     *  https://www.youtube.com/watch?v=p69y8nyISPI&t=360s
     *
     *  1개원판의 처음은 3번째로
     *  2개 원판의 처음은 2번째로
     *  3개는 3번째
     *  4개는 2번째로
     *
     *  홀수일때는 처음이 3번쨰로 시작하고
     *  짝수일떄는 처음이 2번쨰로 시작한다
     *
     *  아래 hanoi의 함수를 보면
     *
     *  n번째 원판만 남았을때 이동을 하기때문에 1이 들어왔을때 3번째로 시작하고
     *
     *  나머지 2, 3, 4, 5..원판들은
     *
     *  짝수번쨰 방식으로 시작
     *  완료시 움직인값 출력
     *
     *  홀수번째 방식으로 시작
     *  완료시 움직인값 출력
     *
     *  하는 방식으로 하노이탑을 최소거리로 이동하는 실제 방식대로
     *  똑같이 작동하게 된다
     *
     */

    /**
     *
     *
     *  어려웠던 점
     *
     *  탑을 옮기는 방법의 가지수가 정말많은데 최소값으로 이동할 공식을 어떻게
     *  찾을 수 있는지 몰랐다
     *
     *  해결방법
     *  1, 2, 3, 4정도의 간단한 예시를 생각해보면
     *  1, 3, 5, 7, 15라는 값이 도출된다 여기서 2^n -1을 알아낼수있고
     *
     *  위와같이 2^n -1이라는 값이 나오는 과정을 증명할 수도있다
     *  이 증명하는 부분이 검색해보지 않고서는 혼자서 찾기에는 너무 무리였을 것 같다
     *
     *
     *  두번째로 하노이가 움직이는 방법은 알고 이동횟수도 알았는데
     *
     *  1, 2, 3번째마다 도착지점이 달라져서 복잡했다
     *  최종적으로 가는 지점은 모두똑같지만
     *
     *  시작점에서 끝점으로 가는 방법이 n-1번째 원판까지 전부 옮기고
     *  n번째 원판을 옮기는 방식의 반복인 상황에서
     *  이러한 논리를 여러번 반복해서 값을 도춣해내는 것 이었기에
     *  중간중간 도착지점이 달라지는 복잡함이 있었다
     *
     *  예를들어 hanoi(N-1, mid, start, to); 홀수번째 시작되는 이 함수가
     *  왜 start가 mid로 전달되고 mid가 start위치로 전달되는지 헷갈렸다
     *
     *  결국에는 여기서 재귀함수가 사용된다는 것을 알았고
     *  위에 말한 것처럼 DFS방식으로 맨아래 원판부터 하나하나 옮긴다고 생각하니까
     *  공식을 보지 않더라도
     *
     *  현재 호출된 하노이 원판 움직이는 공식의
     *  시작점이 어딘지 끝점이 어딘지 직관적으로 알 수 있었다.
     */
    public static void hanoi(int N, int start, int mid, int to) throws IOException {

        if (N == 1) {
            bw.write(start + " " + to + "\n");
            return;
        }

        hanoi(N-1, start, to, mid);

        bw.write(start + " " + to + "\n");

        hanoi(N-1, mid, start, to);
    }

}
