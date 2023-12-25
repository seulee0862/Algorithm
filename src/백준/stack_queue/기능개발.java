package 백준.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

    /**
     *  https://school.programmers.co.kr/learn/courses/30/lessons/42586
     *  문제 내용
     *
     *  프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
     *  또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
     *  먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
     *
     *  제한사항
     *
     *  작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
     *  작업 진도는 100 미만의 자연수입니다.
     *  작업 속도는 100 이하의 자연수입니다.
     *  배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
     *
     *  [95, 90, 99, 99, 80, 99] , [1, 1, 1, 1, 1, 1] -> 출력 [1, 3, 2]
     */

    /**
     *
     * 접근방법
     *
     *  * 2개의 배열을 2개의 queue에 옮겨담은후
     *    2개의 queue를 동시에 순회하면서 문제를 풀기로 했다.
     *
     * 리스트 생성
     * count 생성
     * progress담는 queue생성
     * speeds담는 queue생성
     *
     * 반복문 실행 (!quere.isEmpty())
     *
     * 중첩 반복문 2개생성
     * 1개는 q를 전부돌면서 진행속도를 더한다
     * 1개는 q의 peek()가 100이상일경우 count증가, poll
     *
     * count가 0이아니라면 list에 추가후 count 0으로 변경
     *
     *
     * list배열로 변경
     */

    /**
     *
     *  막혔던 부분
     *
     *  어떻게 풀어야 원하는 값이 나올지 생각하기는 쉬웠다.
     *  하지만 생각보다 많은 반복문이 사용되기 때문에 비효율적이라고 생각되 고민이됐다.
     *  10분동안 좋은 방법이 떠오르지 않았고 처음 생각그대로 구현했다.
     */

    public static void main(String[] args) {

        기능개발 main = new 기능개발();
        int[] a = {95, 90, 99, 99, 80, 99};
        int[] b = {1, 1, 1, 1, 1, 1};

        for (int x : main.solution(a, b )) {
            System.out.println(x);
        }
    }

    public Integer[] solution(int[] progresses, int[] speeds) {

        Integer[] answer;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> prQ = new LinkedList<>();
        Queue<Integer> spQ = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            prQ.offer(progresses[i]);
            spQ.offer(speeds[i]);
        }

        while (!prQ.isEmpty()) {

            for (int i=0; i<prQ.size(); i++) {
                int x = prQ.poll();
                int y = spQ.poll();
                prQ.offer(x+y);
                spQ.offer(y);
            }

            while (prQ.peek() >= 100) {
                prQ.poll();
                spQ.poll();
                count++;
                if (prQ.isEmpty()) break;
            }

            if (count > 0) {
                list.add(count);
                count = 0;
            }
        }

        answer = list.stream()
                .toArray(Integer[]::new);

        return answer;
    }
}
