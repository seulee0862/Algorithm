package 백준.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {

    /**
     *
     *  N이 1개일때부터 8개까지 검색
     *
     *  n 1개로 만들 수 있는 방법
     *  number -> n
     *
     *  n 2개로 만들 수 있는 방법
     *  number -> n+n , n-n, n*n, n/n
     *
     *  n 3개로 만들 수 있는 방법
     *  number > n + (n+n), n + (n-n),.. n/(n/n)
     *
     *  n 1개로 만들 수 있는 방법으로 2개로 만들 수 있는 방법의 가지수를 구하고
     *  4개는 3개, 8개는 7개
     *
     *  1개는 -> 1개 4^0
     *  2개는 -> 4개 4^1
     *  3개는 -> 16개 4^2
     *  4개는 -> 64개 일 것같다 4^3
     *
     *  1개일때 값을 저장
     *  2개일때 값을 저장
     *  3개일때 값을 저장하면
     *  계산이 좀더 빨라질 것 같다
     *
     *  앞서 작은 문제를 통한 값을 이용해서 숫자의 범위가 커져도 계산의 처리량이 주는 방법이 있을 것 같았다
     *  값을 cache하는 방법이 필요할 거라 생각했다
     *
     *  아래는 https://born2bedeveloper.tistory.com/38 풀이를 보고 풀었는데
     *  ArrayList<Set>을 통해서 1~8 번째까지 구했던 값을 계쏙해서 사용할 수 있었다.
     *
     *  DP는 불필요한 계산을 줄이고, 효율적으로 최적해를 찾아야만 풀리는 문제라는데
     *
     *  Set에 저장한 값을 저장하면서 불필요한 게산을 줄였고
     *  효율적인 방법인지는 모르겠지만 나름의 논리적인 방식으로 문제를 풀어나갔다.
     *  DP는 특별히 공식이 없다는 것 같은데 자주 풀어보면 감이올 것같고
     *  큰문제를 작은 문제부터 풀어나간다는 점에서 점화식을 구하면 좋을 것 같다.
     *
     *
     */


    public static void main(String[] args) {
        N으로표현 main = new N으로표현();
    }

    public int solution(int N, int number) {
        List<Set<Integer>> setList = new ArrayList<>();

        if (number == N) return 1;
        for (int i=0; i<9; i++) {
            setList.add(new HashSet<>());
        }
        setList.get(1).add(N);
        for (int i=2; i<9; i++) {
            for (int j=1; j<=i/2; j++) {
                /**
                 * 제일 이해 안갔었던 부분인데 특별한거 없이 순서 괄호의 존재 덕분에 순서를 뒤바꿔도 다른 값이 나올 수가있다.
                 */
                unionSet(setList.get(i), setList.get(i-j), setList.get(j)); // 1,1 / 2, 1 /  3,1  |  2,2 / 4,1  |  3,2 /  5,1  |  4,2  |  3,3
                unionSet(setList.get(i), setList.get(j), setList.get(i-j)); // 1,1 / 1, 2 /  1,3  |  2,2 / 1,4  |  2,3 /  1,5  |  2,4  |  3,3
            }
            String n = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(n.repeat(i)));
            for (int num : setList.get(i)) {
                if (num == number) return i;
            }
        }

        return -1;
    }

    public void unionSet(Set<Integer> union, Set<Integer> a, Set<Integer> b) {
        for (int n1 : a) {
            for (int n2 : b) {
                union.add(n1 + n2);
                union.add(n1 - n2);
                union.add(n1 * n2);
                if (n2 != 0) union.add(n1 / n2);
            }
        }
    }
}
